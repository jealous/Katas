package treeMd5

import (
	"crypto/md5"
	"errors"
	"io/ioutil"
	"os"
	"path/filepath"
	"sync"
)

type result struct {
	path string
	sum  [md5.Size]byte
	err  error
}

func findPaths(root string, done <-chan struct{}) (<-chan string, <-chan error) {
	ret := make(chan string)
	errc := make(chan error, 1)
	go func() {
		defer close(ret)
		errc <- filepath.Walk(root, func(path string, info os.FileInfo, err error) error {
			if err != nil {
				return err
			}
			if info.IsDir() {
				return nil
			}
			select {
			case ret <- path:
			case <-done:
				return errors.New("Walk canceled.")
			}
			return nil
		})
		close(errc)
	}()
	return ret, errc
}

func digest(paths <-chan string, done <-chan struct{}, ret chan result) {
	for path := range paths {
		data, err := ioutil.ReadFile(path)
		select {
		case ret <- result{path, md5.Sum(data), err}:
		case <-done:
			return
		}
	}
}

func sumFilesBounded(root string, done <-chan struct{}) (<-chan result, <-chan error) {
	ret := make(chan result)
	var wg sync.WaitGroup
	const numDigesters = 20
	wg.Add(numDigesters)

	paths, errc := findPaths(root, done)
	for i := 0; i < numDigesters; i++ {
		go func() {
			digest(paths, done, ret)
			wg.Done()
		}()
	}

	go func() {
		wg.Wait()
		close(ret)
	}()
	return ret, errc
}

func sumFiles(root string, done <-chan struct{}) (<-chan result, <-chan error) {
	ret := make(chan result)
	errc := make(chan error, 1)
	go func() {
		var wg sync.WaitGroup
		err := filepath.Walk(root, func(path string, info os.FileInfo, err error) error {
			if err != nil {
				return err
			}
			if info.IsDir() {
				return nil
			}
			wg.Add(1)
			go func() {
				defer wg.Done()
				data, err := ioutil.ReadFile(path)
				select {
				case ret <- result{path, md5.Sum(data), err}:
				case <-done:
				}
			}()

			select {
			case <-done:
				return errors.New("Walk canceled.")
			default:
				return nil
			}
		})
		go func() {
			wg.Wait()
			close(ret)
		}()
		errc <- err
		defer close(errc)
	}()
	return ret, errc
}

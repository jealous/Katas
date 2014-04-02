package pipe

import "sync"

func Gen(nums ...int) <-chan int {
	out := make(chan int)
	go func() {
		for _, n := range nums {
			out <- n
		}
		close(out)
	}()
	return out
}

func Sq(done <-chan struct{}, in <-chan int) <-chan int {
	out := make(chan int)
	go func() {
		defer close(out)
		for n := range in {
			select {
			case out <- n * n:
			case <-done:
				return
			}
		}
	}()
	return out
}

func Merge(done <-chan struct{}, ins ...<-chan int) <-chan int {
	var wg sync.WaitGroup
	out := make(chan int)

	merge := func(in <-chan int) {
		defer wg.Done()
		for n := range in {
			select {
			case out <- n:
			case <-done:
				return
			}
		}
	}
	wg.Add(len(ins))
	for _, in := range ins {
		go merge(in)
	}

	go func() {
		wg.Wait()
		close(out)
	}()
	return out
}

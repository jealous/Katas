package treeMd5

import (
	"fmt"
	"testing"
)

func TestTreeMd5(t *testing.T) {
	done := make(chan struct{})
	//result, err := sumFiles("C:\\work\\script", done)
	result, err := sumFilesBounded("C:\\work\\script", done)
	for r := range result {
		fmt.Printf("filename: %s\t\t\tcheck sum: %x\n", r.path, string(r.sum[:]))
	}
	if err != nil {
		if e := <-err; e != nil {
			fmt.Println("Errors List:")
			fmt.Printf("%x", e.Error())
		}
	}
}

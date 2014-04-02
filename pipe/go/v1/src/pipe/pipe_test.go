package pipe

import (
	"testing"
)

func TestGen(t *testing.T) {
	first := 5
	second := 6
	out := Gen(first, second)
	if first != <-out || second != <-out {
		t.Fail()
	}
}

func TestSq(t *testing.T) {
	in := make(chan int, 2)
	in <- 5
	in <- 6
	done := make(chan struct{})
	defer close(done)

	out := Sq(done, in)
	if 25 != <-out || 36 != <-out {
		t.Fail()
	}

	close(in)
}

func TestPipe(t *testing.T) {
	in := Gen(5, 6)
	done := make(chan struct{})
	defer close(done)
	out := Sq(done, in)
	if 25 != <-out || 36 != <-out {
		t.Fail()
	}
}

func TestMerge(t *testing.T) {
	in := Gen(1, 2, 3, 4, 5, 6, 7)
	fan := make([]<-chan int, 5)
	done := make(chan struct{})
	defer close(done)
	// fan out
	for n := 0; n < 5; n += 1 {
		fan[n] = Sq(done, in)
	}
	out := Merge(done, fan...)
	for n := range out {
		t.Log("Got square: ", n)
	}
}

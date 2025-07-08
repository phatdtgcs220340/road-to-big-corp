package main

import "fmt"

// Climb stairs with provided steps
// 
// Time complexity: O(m^n) (m is length of steps and n is steps)
func main() {
	stairSteps := []int{1, 2, 3, 4}
	fmt.Print(climbStairs(30, stairSteps))
}

func climbStairs(n int, stairSteps []int) int {
	count := new(int);
	*count = 0
	backtrack(n, count, stairSteps);

	return *count
}

func backtrack(n int, count *int, stairSteps []int) {
	if n < 0 {
		return
	}
	if n == 0 {
		(*count)++
		return
	}

	for _, step := range stairSteps {
		backtrack(n - step, count, stairSteps);
	}
}

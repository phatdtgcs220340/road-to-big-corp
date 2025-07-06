package main 

import "fmt"
func main() {
	nums := []int{2, 7, 11, 15}
	result := twoSum(nums, 9)

	for _, n := range result {
		fmt.Printf("%d ", n)
	}
}

func twoSum(nums []int, target int) []int {
	pos := make(map[int]int)
	for i, n := range nums {
		value, exists := pos[target - n]
		if exists {
			return []int{value, i}
		} else {
			pos[n] = i
		}
	}
	return nil
}


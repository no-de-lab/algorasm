package array

import "fmt"

func plusOne(digits []int) []int {
	next := 0
	val := 0

	for i := len(digits) - 1; i >= 0; i-- {
		if i == len(digits)-1 {
			next = 1
		}
		val = digits[i] + next
		digits[i] = val % 10
		next = val / 10

	}

	if next > 0 {
		digits = append([]int{next}, digits...)
		fmt.Println(digits)
	}
	fmt.Println(digits)
	return digits
}

func plusOne2(digits []int) []int {
	for i := len(digits) - 1; i >= 0; i-- {
		if digits[i] < 9 {
			digits[i]++
			return digits
		}
		digits[i] = 0
	}
	digits = append([]int{1}, digits...)
	return digits
}

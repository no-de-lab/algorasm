/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?

=> after reverse all array and reverse slice until k

how to array reverse ? with recursive slice
func reverseInts(input []int) []int {
	if len(input) == 0 {
		return input
	}
	return append(reverseInts(input[1:]), input[0])
}

func reverse(target []int, start, end int) {
	for start < end {
		temp := target[start]
		target[start] = target[end]
		target[end] = temp
		start++
		end--
	}
}

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

1 <= nums.length <= 2 * 10^4
It's guaranteed that nums[i] fits in a 32 bit-signed integer.
k >= 0
*/

package array

import (
	"fmt"
)

// Rotate array
func Rotate(nums []int, k int) {
	fmt.Println(k)
	if len(nums) >= k {
		sliceArray := nums[len(nums)-k : len(nums)]

		cutArray := nums[0 : len(nums)-k]
		result := append(sliceArray, cutArray...)
		for index, value := range result {
			nums[index] = value
		}
		fmt.Println(nums)
	} else {
		Rotate(nums, k%len(nums))
	}

}

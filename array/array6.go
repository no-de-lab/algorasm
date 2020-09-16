/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

package array

// Intersect Intersection of Two Arrays II
func Intersect(nums1 []int, nums2 []int) []int {
	sumArray := make([]int, 0)
	compareArray := make([]int, 0)

	save := map[int]int{}
	list := make([]int, 0)

	// temp = nums1
	// nums2 > nums1 => temp = nums2
	sumArray = nums1
	compareArray = nums2
	if len(nums1) < len(nums2) {
		sumArray = nums2
		compareArray = nums1
	}

	for _, value := range compareArray {
		save[value]++
	}

	for _, value := range sumArray {
		if save[value] > 0 {
			list = append(list, value)
			save[value]--
		}
	}
	return list
}

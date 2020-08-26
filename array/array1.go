package array

// RemoveDuplicates array sort
func RemoveDuplicates(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	i := 0
	for index, value := range nums {
		// if nums[index] not duplicate, rewrite number in nums[i]
		if value != nums[i] {
			i++
			nums[i] = nums[index]
		}
	}
	return i + 1
}

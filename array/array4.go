package array

// ContainsDuplicate contain
func ContainsDuplicate(nums []int) bool {
	save := map[int]bool{}
	checkDuplicate := false
	for index, value := range nums {
		if save[nums[index]] != true {
			save[value] = true
		} else {
			checkDuplicate = true
		}
	}
	return checkDuplicate
}

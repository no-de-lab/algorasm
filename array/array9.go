package array

func twoSum(nums []int, target int) []int {
	check := map[int]int{}
	// [3,3]
	for i, v := range nums {

		gap := target - v
		value, isExist := check[gap]
		if isExist {
			return []int{value, i}
		} else {
			check[v] = i
		}

	}
	return nums
}

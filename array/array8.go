package array

import "sort"

func moveZeroes(nums []int) {
	check := false
	for _, value := range nums {
		if value == 0 {
			check = true
		}
	}

	if check {
		// not guaranted argument of list
		// 	    sort.Slice(nums, func(_, j int) bool {
		// 	    return nums[j] == 0
		// 	    })

		// use SliceStable
		sort.SliceStable(nums, func(_, j int) bool {
			return nums[j] == 0
		})
	}
}

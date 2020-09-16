package array

func singleNumber(nums []int) int {
	save := map[int]bool{}
	for index, value := range nums {
		if save[nums[index]] != true {
			save[value] = true
		} else {
			save[value] = false
		}
	}
	single := 0

	for index, value := range save {
		if value == true {
			single = index
		}
	}
	return single
}

// single pass and xor ( no extra memory)
func singleNumber2(nums []int) int {

	var n int

	for _, v := range nums {
		n = n ^ v
	}

	return n

}

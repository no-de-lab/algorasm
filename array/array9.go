package array

func twoSum(nums []int, target int) []int {
	check := map[int][]int{}

	for i, v := range nums {
		check[v] = append(check[v], i)

		if len(check[target-v]) >= 1 {
			if v == target-v && len(check[v]) > 1 {
				return check[v]
			} else if v != target-v {
				return []int{check[target-v][0], check[v][0]}
			}
		}
	}

	return nums
}

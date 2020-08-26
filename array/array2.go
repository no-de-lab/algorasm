package array

import (
	"fmt"
	"strconv"
)

// MaxProfit get maxprofit
func MaxProfit(prices []int) int {
	profit := 0
	// buy := 0
	// sell := 0
	check := 0
	for index, value := range prices {
		check = index + 1
		if check == len(prices) {
			break
		}
		fmt.Printf(strconv.Itoa(value) + "\n")
		// compare backword, forward
		temp := prices[check] - value
		if temp > 0 {
			profit += temp
		}
		fmt.Printf(strconv.Itoa(profit) + "\n")

	}
	return profit
}

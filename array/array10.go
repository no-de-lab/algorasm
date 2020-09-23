package array

import (
	"fmt"
	"strconv"
)

func isValidSudoku(board [][]byte) bool {

	for i := 0; i < 9; i++ {
		checkRow := map[int]int{}
		checkColumn := map[int]int{}
		for j := 0; j < 9; j++ {
			// row
			rowByteNumber := board[i][j]
			rowByteToInt, _ := strconv.Atoi(string(rowByteNumber))
			checkRow[rowByteToInt]++

			// column
			columnByteNumber := board[j][i]
			columnByteToInt, _ := strconv.Atoi(string(columnByteNumber))
			checkColumn[columnByteToInt]++
		}

		for i, v := range checkRow {
			if i != 0 && v > 1 {
				return false
			}
		}

		for i, v := range checkColumn {
			if i != 0 && v > 1 {
				return false
			}
		}
	}

	for i := 0; i < 9; i = i + 3 {
		for j := 0; j < 9; j = j + 3 {
			checkRow := map[int]int{}
			checkColumn := map[int]int{}
			for row := i; row < i+3; row++ {
				for column := j; column < j+3; column++ {
					rowByteNumber := board[row][column]
					rowByteToInt, _ := strconv.Atoi(string(rowByteNumber))
					checkRow[rowByteToInt]++

					// column
					columnByteNumber := board[column][row]
					columnByteToInt, _ := strconv.Atoi(string(columnByteNumber))
					checkColumn[columnByteToInt]++
				}
				for index, v := range checkRow {
					if index != 0 && v > 1 {
						fmt.Println(checkRow)
						return false
					}
				}

				for index, v := range checkColumn {
					if index != 0 && v > 1 {
						fmt.Println("2")
						return false
					}
				}
			}

		}
	}

	return true
}

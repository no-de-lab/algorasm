func rotate(matrix [][]int) {
	for i := 0; i < len(matrix); i++ {
		for j := i + 1; j < len(matrix); j++ {

			temp := matrix[j][i]
			// temp2:= matrix[len(matrix)-1-i][j]
			// temp3:= matrix[len(matrix)-1-i][len(matrix)-1-i]
			// temp4:= matrix[j][len(matrix)-1-i]
			// fmt.Println(temp1)
			// fmt.Println(temp2)
			// fmt.Println(temp3)
			// fmt.Println(temp4)
			// fmt.Println("~~~~~~~~~~~")
			matrix[j][i] = matrix[i][j]
			// matrix[j][len(matrix)-1-i] = temp1
			// matrix[len(matrix)-1-i][len(matrix)-1-i] = temp4
			// matrix[len(matrix)-1-i][j] = temp3
			matrix[i][j] = temp

		}
	}

	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix)/2; j++ {
			temp := matrix[i][len(matrix)-1-j]
			matrix[i][len(matrix)-1-j] = matrix[i][j]
			matrix[i][j] = temp
		}
	}
}
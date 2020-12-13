/**
 Do not return anything, modify matrix in-place instead.
 */
function rotate(matrix: number[][]): void {
  interface Memo {
    [index: number]: number[];
  }

  const memo: Memo = {};

  for (let i: number = 0; i < matrix.length; i++) {
    memo[i] = [...matrix[i]];
  }

  for (let i: number = 0; i < matrix.length; i++) {
    for (let j: number = 0; j < matrix[i].length; j++) {
      matrix[i][j] = memo[matrix.length - j - 1][i];
    }
  }
}

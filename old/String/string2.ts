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

function reverse(x: number): number {
  const parsed: string = x.toString();
  const array: string[] = parsed.split("");

  let left: number = array[0] === "-" ? 1 : 0;
  let right: number = array.length - 1;
  let temp: string;

  while (left < right) {
    temp = array[left];
    array[left] = array[right];
    array[right] = temp;

    left++;
    right--;
  }

  const answer: number = Number(array.join(""));

  if (Math.pow(-2, 31) > answer || answer >= Math.pow(2, 31) - 1) return 0;
  else return answer;
}

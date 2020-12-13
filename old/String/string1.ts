/**
 Do not return anything, modify s in-place instead.
 */
function reverseString(s: string[]): void {
  // s.reverse();

  let left: number = 0;
  let right: number = s.length - 1;
  let temp: string;

  while (left < right) {
    temp = s[left];
    s[left] = s[right];
    s[right] = temp;

    left++;
    right--;
  }
}

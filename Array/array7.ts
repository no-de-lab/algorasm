// 코드 1
function plusOne(digits: number[]): number[] {
  const digit: bigint = BigInt(digits.join("")) + BigInt(1);
  return digit
    .toString()
    .split("")
    .map((c) => +c);

  // return (BigInt(digits.join('')) + BigInt(1)).toString().split('').map((c) => +c);
}

// 코드 2
function plusOne(digits: number[]): number[] {
  ++digits[digits.length - 1];
  let carry: number = 0;

  for (let i: number = digits.length - 1; i >= 0; i--) {
    digits[i] += carry;
    carry = 0;

    if (digits[i] > 9) {
      digits[i] -= 10;
      carry = 1;
    }
  }

  if (carry) digits.unshift(1);
  return digits;
}

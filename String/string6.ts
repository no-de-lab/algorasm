// 포기

function myAtoi(s: string): number {
  const trimmedS = s.trim();
  let i = 0;

  while (trimmedS[i] === "0") {
    i++;
  }

  const parsedS = trimmedS.substring(i);

  if (!isValidType(parsedS.substring(0, 2))) return 0;

  // console.log(trimmedS);

  let left: number | undefined;
  let right: number | undefined;

  for (let i = 0; i < parsedS.length; i++) {
    if (left === undefined) {
      if (Number(parsedS[i])) {
        left = i;
      } else if (
        (parsedS[i] === "+" || parsedS[i] === "-") &&
        Number(parsedS[i + 1])
      ) {
        left = i;
        continue;
      }
    }

    if (typeof left === "number") {
      if (isNaN(Number(parsedS[i]))) {
        right = i;
        break;
      }
      if (i === parsedS.length - 1) {
        right = i + 1;
        break;
      }
    }
  }

  console.log(left, right);

  if (typeof left === "number") {
    const answer: number = Number(parsedS.substring(left, right));
    if (answer > Math.pow(2, 31) - 1) {
      return Math.pow(2, 31) - 1;
    } else if (answer < Math.pow(-2, 31)) {
      return Math.pow(-2, 31);
    }
    return answer;
  }

  return 0;
}

function isValidType(x: string): boolean {
  if (x[0] !== "." && Number(x)) return true;
  return false;
}

console.log(myAtoi("21474836460"));
console.log(myAtoi("  0000000000012345678"));

Language : typescript

포인트는 팰린트롬을 매번 검사하지 않고 왼쪽 오른쪽으로 값이 같은지만 확인하고 같으면 dp에 넣어줬어요!
```typescript
function longestPalindrome(s: string): string {
  const dp = new Array(s.length);

  const length = dp.length;
  for (let i = 0; i < length; i++) {
    dp[i] = [];
  }

  const inputs = s.split("");
  inputs.forEach((cur, index) => {
    dp[0].push(index);
    if (cur === s[index + 1]) {
      dp[1].push(index);
    }
  });

  let cnt = 1;
  while (cnt++ !== length) {
    const prev: number[] = dp[cnt - 2];

    prev.forEach(el => {
      if (cnt % 2 === 0) {
        const len = cnt / 2;

        if (s.charAt(el - len) === s.charAt(el + len)) {
          dp[cnt].push(el);
        }

        return;
      }

      const len = Math.floor(cnt / 2);

      if (s.charAt(el - len) === s.charAt(el + 1 + len)) {
        dp[cnt].push(el);
      }
    });
  }

  for (let i = length - 1; i >= 0; i--) {
    if (dp[i].length === 0) {
      continue;
    }

    const len = Math.floor(i / 2);
    const cur = dp[i][0];

    if (i % 2 === 0) {
      const len = i / 2;
      return (
        s.substring(cur - len, cur + 1) + s.substring(cur + 1, cur + 1 + len)
      );
    }

    return s.substring(cur - len, cur + 2 + len);
  }

  return "";
}
```

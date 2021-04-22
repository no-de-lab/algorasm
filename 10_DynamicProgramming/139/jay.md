Language : typescript

포인트는 팰린트롬을 s를 한글자씩 추가해가면서 모든 경우의 수를 set에 넣어줬어요.
하지만 dict에서 replace가 가능하다고 왼쪽에 글자가 남아있지 않으면 글자가 제대로 잘린다고 보고 dp에 추가하는 식으로 짜봤어요! 
```typescript
function wordBreak(s: string, wordDict: string[]): boolean {
  const dp = new Array(s.length + 1);

  for (let i = 1; i < dp.length; i++) {
    dp[i] = new Set();
  }

  let word = s.charAt(0);
  dp[1].add(word);
  wordDict.forEach(dict => {
    if (word.indexOf(dict) !== -1) {
      dp[1].add("");
    }
  });
  for (let i = 2; i <= s.length; i++) {
    const prev: Set<string> = dp[i - 1];

    prev.forEach(el => {
      const curWord = el + s.charAt(i - 1);
      dp[i].add(curWord);

      wordDict.forEach(dict => {
        if (curWord.indexOf(dict) === -1) {
          return;
        }

        const replaced = curWord.replace(dict, "");
        if (replaced === "") {
          dp[i].add("");
        }
      });
    });
  }

  const resultDp: Set<string> = dp[s.length];

  if (resultDp.has("")) {
    return true;
  }

  return false;
}
```

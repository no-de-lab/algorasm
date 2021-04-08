언어: 타입스크립트


```typescript
const MAX_COUNT = 8;
let N;
let target;
const dp = new Array(MAX_COUNT + 1);
const maxValues = [];
const totalSet = new Set();

function solution(n, number) {
  N = n;
  target = number;

  if (target === N) {
    return 1;
  }

  for (let i = N, count = 0; count <= MAX_COUNT; count++, i = i * 10 + N) {
    maxValues[count] = i;
    totalSet.add(i);
  }

  for (let i = 1; i <= 8; i++) {
    dp[i] = new Set();
    dp[i].add(maxValues[i - 1]);
  }

  for (let i = 2; i <= MAX_COUNT; i++) {
    // j는 현재 i의 -1부터 시작하고 k는 1부터 시작해서 서로 아래, 위로 올라가면서 dp Set을 채워 나가야 함!
    let k = 1;
    for (let j = i - 1; j > 0; j--, k++) {
      for (let itemJ of dp[j].values()) {
        for (let itemK of dp[k].values()) {
          const plus = itemJ + itemK;
          const minus = itemJ - itemK;
          const multiply = itemJ * itemK;
          const division = itemJ / itemK;

          if (isValid(plus)) {
            dp[i].add(plus);
          }
          if (isValid(minus)) {
            dp[i].add(minus);
          }
          if (isValid(multiply)) {
            dp[i].add(multiply);
          }
          if (isValid(division)) {
            dp[i].add(division);
          }
        }
      }

      if (dp[i].has(target)) {
        return i;
      }
    }
  }

  return -1;
}

function isValid(number) {
  if (number < 1) {
    return false;
  }

  if (number > 32000) {
    return false;
  }

  if (totalSet.has(number)) {
    return false;
  }

  totalSet.add(number);
  return true;
}
```

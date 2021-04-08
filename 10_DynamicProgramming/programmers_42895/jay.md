언어 : javascript



처음에 DFS로 사칙연산을 순회하면서 풀어봤는데 50점 정도밖에 안 나와서 뭐가 문젠지 생각해보니 (55 * 5)(55 / 5) 
이런 케이스의 경우 검사가 불가능.. Set으로 dp를 돌릴 생각을 못했었네요 :(

```javascript
const MAX_COUNT = 8;
let N;
let target;
const dp = new Array(9);
const maxValues = [];
function solution(n, number) {
  N = n;
  target = number;

  if (target === N) {
    return 1;
  }

  for (let i = N, count = 0; count <= MAX_COUNT; count++, i = i * 10 + N) {
    maxValues[count] = i;
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
          dp[i].add(itemJ + itemK);
          dp[i].add(itemJ - itemK);
          dp[i].add(itemJ * itemK);
          dp[i].add(itemJ / itemK);
        }
      }

      if (dp[i].has(target)) {
        return i;
      }
    }
  }

  return -1;
}
```

Link : https://leetcode.com/problems/n-th-tribonacci-number/

Language : JavaScript

Time Complexity : O(N)

Space Complexity : O(N)

```javascript
/**
 * @param {number} n
 * @return {number}
 */
var tribonacci = function (n) {
  if (n < 2) return n;

  let a = 0;
  let b = 1;
  let c = 1;
  let d;

  for (let i = 2; i < n; i++) {
    d = a + b + c;
    a = b;
    b = c;
    c = d;
  }

  return c;
};

// Java DP 풀이
// public int tribonacci(int n) {
//         int dp[] = {0, 1, 1};
//         for (int i = 3; i <= n; ++i)
//             dp[i % 3] = dp[0] + dp[1] + dp[2];
//         return dp[n % 3];
// }
```

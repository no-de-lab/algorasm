Link : https://leetcode.com/problems/unique-paths/submissions/

Language : JavaScript

Time Complexity : O(N^2)

Space Complexity : O(N^2)

```javascript
/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
const uniquePaths = function(m, n) {
    const map = new Array(m).fill([]);

    for (let i = 0; i < map.length; i++) {
        for (let j = 0; j < n; j++) {
            if (i - 1 < 0 || j - 1 < 0) {
                map[i][j] = 1;
            }
            else {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
    }

    return map[m - 1][n - 1];
};
```

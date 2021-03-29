Link : https://leetcode.com/problems/k-th-symbol-in-grammar/

Language : JavaScript

Time Complexity : O(logN)

Space Complexity : O(logN)

```javascript
/**
 * @param {number} N
 * @param {number} K
 * @return {number}
 */
const kthGrammar = function(N, K, row = 1, value = 0) {
        if (row === N) return value;

        const numberOfLeaf = Math.pow(2, N - row);   // 현재 Tree 에서 최하단 Leaf Node 들의 수

        if (K <= numberOfLeaf / 2) {
            const leftNewValue = value === 0 ? 0 : 1;

            return kthGrammar(N, K, row + 1, leftNewValue);
        }
        else if (K > numberOfLeaf / 2) {
            const newK = K - numberOfLeaf / 2;              // binary tree 의 오른쪽 기준으로 새로운 index 값 부여
            const rightNewValue = value === 0 ? 1 : 0;

            return kthGrammar(N, newK, row + 1, rightNewValue);
        };
    };

```

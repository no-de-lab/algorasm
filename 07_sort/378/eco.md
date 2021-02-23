Link : https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

Language : JavaScript

- Time Complexity | Space Complextity :   
    - 풀이 1 : O(N^2) | O(N)
    - 풀이 2 :  O(logN) | O(1)

```javascript
/**
 * @param {number[][]} matrix
 * @param {number} k
 * @return {number}
 */
const kthSmallest = function(matrix, k) {
    
    // 1. Time O(N^2) | Space O(N)
    const array = [];
    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            array.push(matrix[i][j]);
        }
    }
    array.sort((a, b) => a - b);
    return array[k - 1];
    
    
    // 2. Time O(logN) | Space O(1);
    // 이진 탐색 기법으로 매 loop 마다 탐색할 데이터를 반씩 줄인다.
    let small = matrix[0][0];
    let big = matrix[matrix.length - 1][matrix[0].length - 1];

    while (small < big) {
        let middle = small + Math.floor((big - small) / 2);
        let count = 0;
        let j = matrix[0].length - 1;

        for (let i = 0; i < matrix.length; i++) {
            while (j >= 0 && matrix[i][j] > middle) {
                j--;
            }
            count += (j + 1);
        }
        if (count < k) small = middle + 1;
        else big = middle;
    }
    return small;
};
```

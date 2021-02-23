Link : https://leetcode.com/problems/squares-of-a-sorted-array/

Language : JavaScript

Time Complexity : O(N)

Space Complexity : O(N)

```javascript
/**
 * @param {number[]} nums
 * @return {number[]}
 */
const sortedSquares = function(nums) {
        // 음수가 없다면, 그대로 제곱만 하면 끝이지만
        // 음수간 있다면, 왼쪽 끝과 오른쪽 끝이 각각 가장 큰 절대값을 가짐
        const result = [];
        let cur = nums.length - 1;
        let left = 0;
        let right = nums.length - 1;

        while (left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                result[cur] = Math.pow(nums[right], 2);
                right--;
            } else {
                result[cur] = Math.pow(nums[left], 2);
                left++;
            }
            cur--;
        }

        return result;
    };
```


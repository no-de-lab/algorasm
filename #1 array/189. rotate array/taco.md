## taco

###### 배열 189. Rotate Array

```
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
  const newNums = nums.splice(nums.length-k, k);
    nums.unshift(...newNums)


//     for(let i = 0; i<k; i++){
//        nums.unshift(nums.pop())
//     }


};
```

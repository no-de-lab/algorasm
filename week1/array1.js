/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
  const rotating = k % nums.length;
  const copy = [...nums];
  for (let i = 0; i < nums.length; i++) {
    const newIdx = i - rotating < 0 
                  ? nums.length - (rotating - i)
                  : i - rotating;
    nums[i] = copy[newIdx];
  }
};
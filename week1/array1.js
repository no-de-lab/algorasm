/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
  const j = k % nums.length;
  const copy = [...nums];
  for (let i = 0; i < nums.length; i++) {
    const newIdx = i - j < 0 
                  ? nums.length - (j - i)
                  : i - j;
    nums[i] = copy[newIdx];
  }
};
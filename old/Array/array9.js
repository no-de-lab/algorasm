/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
  let memo = {};
  let result = [];
  for (let i = 0; i < nums.length; i++) {
    let value = nums[i];
    let gap = target - value;
    if (memo[gap] !== undefined) {
      return [i, memo[gap]];
    } else memo[value] = i; // (key - 값 : value - index) 로 memo
  }
};

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function (nums) {
  const memo = {};
  return nums.some((c) => {
    // memo 에 이미 있는 수 중 하나라도 발견되면 loop 종료하고 return true
    if (memo[c]) return true;
    memo[c] = true;
  });
};

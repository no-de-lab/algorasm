/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function (nums, k) {
  if (nums.length > 1) {
    const move = k % nums.length;

    for (let i = 0; i < nums.length; i++) {
      nums[i] = {
        prev: nums[i],
      };
    }

    for (let i = 0; i < nums.length; i++) {
      let newIndex =
        i - move >= 0 ? i - move : nums.length + ((i - move) % nums.length);

      nums[i] = {
        ...nums[i],
        cur: nums[newIndex].prev,
      };
    }

    for (let i = 0; i < nums.length; i++) {
      nums[i] = nums[i].cur;
    }
  }
};

// const nums = [1, 2];
//-3, -2, -1, 0, 1, 2, 3

const nums = [1, 2, 3, 4, 5, 6, 7];
//   -3 -2 -1 0, 1, 2, 3, 4, 5, 6

rotate(nums, 3);

console.log(nums);

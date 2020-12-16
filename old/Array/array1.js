/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
    let unique = 0;
  
    for (let i = 1; i < nums.length; i++) {
      if (nums[unique] !== nums[i]) {
        nums[++unique] = nums[i];
      }
    }
  
    // array 의 unique 값들만으로 구성된 부분까지의 길이를 return 해야함
    return unique + 1;
  };

/**
 Do not return anything, modify nums in-place instead.
 */
function moveZeroes(nums: number[]): void {
  let i: number = 0;
  let foundZero: boolean = false;
  let lastIdx: number = nums.length - 1;

  while (i <= lastIdx) {
    if (foundZero) {
      nums[i - 1] = nums[i];
    }

    if (!foundZero && nums[i] === 0) {
      foundZero = true;
    }

    if (i === lastIdx) {
      if (foundZero) {
        nums[lastIdx] = 0;
        lastIdx--;
        foundZero = false;
        i = 0;
        continue;
      }
      if (!foundZero) break;
    }
    i++;
  }
}

// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]

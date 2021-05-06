```javascript
var maxProduct = function(nums) {
    for(let i = 1; i<nums.length; i++){
       nums[i] = Math.max(nums[i], nums[i]* nums[i-1])
   }
    return Math.max(...nums)
};

var maxProduct = function(nums) {
    let min = nums[0];
    let max = nums[0];
    let answer = nums[0];
    
    for(let i = 1; i<nums.length; i++){
        let firstMax = nums[i]* max
        let firstMin = nums[i] * min
        max = Math.max(nums[i], Math.max(firstMax, firstMin))
        min = Math.min(nums[i], Math.min(firstMax, firstMin))
        answer = Math.max(answer, max)
    }
    return answer
   
};
```
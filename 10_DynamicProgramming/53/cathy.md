```javascript
const maxSubArray = function(nums) {
    let max = -100000;
    let temp = 0;
    
    for (let n of nums) {
        temp += n;
        max = Math.max(max, temp);
        if(temp < 0) {
            temp = 0;
        }
    }
    return max;
};
```
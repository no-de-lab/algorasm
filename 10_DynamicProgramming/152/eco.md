Link : https://leetcode.com/problems/maximum-product-subarray/

Language : JavaScript

Time limit exceeded.. 
```javascript
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
        const dp = {};

        for (let i = 0; i < nums.length; i++) {
            dp[i] = {
                max: nums[i],
                subs: {}
            };

            for (let j = 0; j < nums.length - i; j++) {
                dp[i].subs[j] = {
                    product: 1,
                    array: []
                }

                for (let k = i; k <= j + i; k++) {
                    dp[i].subs[j].product *= nums[k];
                    dp[i].subs[j].array.push(nums[k]);

                    dp[i].max = Math.max(dp[i].max, dp[i].subs[j].product);
                }
                // console.log('i: ', i, 'j: ', j, 'array: ', dp[i].subs[j].array)

            }

        }

        // console.log(dp);

        let maxProduct = nums[0];
        for (let key in dp) {
            maxProduct = Math.max(dp[key].max, maxProduct);
        }

        return maxProduct;
    };
```

풀이보고 해결한 답안 :
```javascript
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    let product = 1;
    let result  = -Infinity;
    
    for (let n of nums) {
        product *= n;
        result = Math.max(product, result);
        if (product === 0) product = 1;
    }
    
    product = 1;
    
    for (let i = nums.length - 1; i > 0; i--) {
        product *= nums[i];
        result = Math.max(product, result);
        if (product === 0) product = 1;
    }

    return result;
};
```

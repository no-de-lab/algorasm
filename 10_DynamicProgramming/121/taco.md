```javascript
/**
 * @param {number[]} prices
 * @return {number}
 */

let min=0;

var maxProfit = function(prices) {
    min = prices[0];
    let result=0;
    for(let i = 0;i<prices.length;i++){
        if(min>prices[i]){
            min= prices[i];
        }
        let max=prices[i];
        if(result<max-min){
            result = max-min
        }
        
    }
    return result;
    
};
```
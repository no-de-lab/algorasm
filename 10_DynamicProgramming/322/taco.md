```javascript
/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount, dp={}) {    
    let min = Infinity, count;

    if(amount in dp) return dp[amount];
    if(amount == 0) return 0;
    if(amount < 0) return -1;

    coins.forEach((coin) => {
        count = coinChange(coins, amount-coin, dp)
        if(count != -1) min = Math.min(min, 1+count)
    })
    return (min == Infinity) ? dp[amount] = -1 : dp[amount] = min;
   
};



```
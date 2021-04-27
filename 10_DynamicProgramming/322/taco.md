```javascript
/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
const big = 11111111;
var coinChange = function(coins, amount) {
    let answer = describe(coins, amount, 0, 0)
    return answer;
};

function describe(c, a, count, res){
    if(a == res) return count;
    if(a < res) return -1;
    let num = big;
    let random = c[Math.floor(Math.random()*c.length)]
    while(a > res){
        num = Math.min(num, describe(c, a, count+1, res + random));
    }   
    return num;
}
```
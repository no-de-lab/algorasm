Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Language : JavaScript

Time Complexity : O(N)

Space Complexity : O(N)

```javascript
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  let profit = 0;
  let minPrice = prices[0];

  for (let i = 0; i < prices.length; i++) {
    if (prices[i] < minPrice) {
      minPrice = prices[i];
      continue;
    }

    const tempProfit = prices[i] - minPrice;
    if (tempProfit > profit) profit = tempProfit;
  }

  return profit;
};
```

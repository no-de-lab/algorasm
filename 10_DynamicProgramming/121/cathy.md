

```javascript
const maxProfit = function(prices) {
    let max = 0;
    for(let i = 0; i < prices.length -1; i++) {
      for(let j = i+1; j < prices.length; j++) {
        // 처음에 왜 이렇게 했었을까....?  ... 굳이...? 
        let tmp = prices[j] - prices[i];
        if(max < tmp) max = tmp;
      }
    }
    return max;
};
```
결과... Time Limit Exceeded.... 

반복문을 줄여보자..

```javascript
const maxProfit = function(prices) {
  // 어차피 비교 대상은 하나가 필요하니 선언할 때 첫번째 값을 저장함
  let buy = prices[0];
  let max = 0;

  for(let i = 1; i < prices.length; i++) {
    // 비교하면서 전날보다 가격이 오르면 ? prices[i] - buy 로 기존 max 와 비교
    if(prices[i] > prices[i-1]) {
      max = Math.max(max, prices[i] - buy);  
    } else {
      // 낮은값 유지 
      buy = Math.min(buy, prices[i]);
    }
  }
}
```
흠... 문제를 정확히 파악하는 것도 중요한 듯 
너무 단순하게 다 비교해보면 되지? 라고 생각헀던 것 같다... ? 

Language : Typescript

min을 매번 검사해서 갱신해주고 min을 기준으로 각 dp에 최대 이익을 남긴 다음에 reduce로 최대 값을 반환햇습니당
```typescript
function maxProfit(prices: number[]): number {
    const dp = new Array(prices.length).fill(0);

    let min = Number.MAX_SAFE_INTEGER;

    prices.forEach((price, index) => {
        if (min > price) {
            min = price;
            return;
        }

        dp[price] = price - min;
    });

    return dp.reduce((a, b) => Math.max(a, b));
}
```

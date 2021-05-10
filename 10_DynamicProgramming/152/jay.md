```typescript
function maxProduct(nums: number[]): number {
    const dp: Set<number>[] = new Array(nums.length).fill(null);
    let max = -Infinity;

    for (let i = 0; i < dp.length; i++) {
        dp[i] = new Set();
    }

    nums.forEach((num, index) => {
        const now = dp[index];

        if (index !== 0) {
            const prev = dp[index - 1];

            prev.forEach(el => {
                const value = el * num;
                now.add(value);
                // 연속된 배열이 정답일 경우 
                max = Math.max(max, value);
            });
        }

        now.add(num);
        // 단일 배열이 정답일 경우
        max = Math.max(max, num);
    });

    return max;
}
```
```typescript
function maxSubArray(nums: number[]): number {
    const dp = new Array(nums.length + 1).fill(0);

    let max = -Infinity;
    nums.forEach((num, index) => {
        const temp = Math.max(dp[index] + num, num);
        dp[index + 1] = temp;
        if (temp > max) {
            max = temp;
        }
    });

    return max;
}

```
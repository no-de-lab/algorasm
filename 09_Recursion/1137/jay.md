언어: typescript


```typescript
function tribonacci(n: number): number {
    const cachedNumbers: number[] = [];
    cachedNumbers.push(0);
    cachedNumbers.push(1);
    cachedNumbers.push(1);

    for (let i = 3; i <= n; i++) {
        cachedNumbers[i] = cachedNumbers[i - 3] + cachedNumbers[i - 2] + cachedNumbers[i - 1];
    }

    return cachedNumbers[n];
};
```

Language : typescript

```typescript
function kthSmallest(matrix: number[][], k: number): number {
  const results: number[] = [];
  matrix.forEach(array => array.forEach(el => results.push(el)));
  results.sort((a, b) => a - b);
  return results[k - 1];
};
```

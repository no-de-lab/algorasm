Language : Typescript

```typescript
function sortedSquares(nums: number[]): number[] {
    const newNums = nums.map(num => num * num);
    return qSort(newNums);
};

function qSort(nums: number[]): number[] {
    if (nums.length <= 1) {
        return nums;
    }

    const pivot = nums[0];
    const left = [];
    const right = [];

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] < pivot) {
            left.push(nums[i]);
            continue;
        }
        right.push(nums[i]);
    }
    const result = qSort(left);
    result.push(pivot);
    return result.concat(qSort(right));
}
```


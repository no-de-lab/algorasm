언어: typescript

```typescript
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

function diagonalSort(mat: number[][]): number[][] {

    for (let i = mat.length - 1; i >= 0; i--) {
        let row = i;
        let col = 0;
        let temp = [];
        let rc: number[][] = [];
        while(mat[row] && mat[row][col]) {
            temp.push(mat[row][col]);
            rc.push([row, col]);
            row += 1;
            col += 1;
        }
        temp = qSort(temp);
        temp.forEach((value, index) => {
            mat[rc[index][0]][rc[index][1]] = value;
        })
    }

    for (let i = 1; i < mat[0].length; i++) {
        let row = 0;
        let col = i;
        let temp = [];
        let rowcol: number[][] = [];
        while(mat[row] && mat[row][col]) {
            temp.push(mat[row][col]);
            rowcol.push([row, col]);
            row += 1;
            col += 1;
        }
        temp = qSort(temp);
        temp.forEach((value, index) => {
            mat[rowcol[index][0]][rowcol[index][1]] = value;
        })
    }

    return mat;
};
```

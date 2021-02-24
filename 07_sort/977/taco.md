```javascript
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortedSquares = function(nums) {
    // 일단 돌아가면서 제곱을 map 해준담에
    // 그걸 sortㅎㅐ주기
    // 아니면, 절대값으로 sort하고
    let newN = nums.map((n) => {
        return Math.abs(n)
    })
    console.log(newN)
    newN = newN.map((n) => {
        return Math.pow(n, 2);
    })
    newN.sort((a,b) => {
        return a-b
    })
    return newN
};
```
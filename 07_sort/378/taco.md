```javascript
/**
 * @param {number[][]} matrix
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(matrix, k) {
    let newArr = [];
    
    matrix.forEach((m) => {
        newArr.push(...m)
    })
        
    
    newArr.sort((a,b)=>{
        return a-b
    })
    
    return newArr[k-1]
    
};
```
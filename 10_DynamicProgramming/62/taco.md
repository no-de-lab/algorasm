```javascript
/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    if(m == 1 || n == 1) return 1;
    
    if(m>1 && n >1){
        return uniquePaths(m-1, n) + uniquePaths(m, n-1)
    }
    
    
};
```
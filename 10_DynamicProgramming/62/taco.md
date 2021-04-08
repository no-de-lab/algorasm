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

/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    let obj = {}
    if(m == 0 || n == 0){
        obj[(m,n)] = 0;
        return 0;
    }
    if(m == 1 && n == 1){
        obj[(m,n)] = 1
        return 1;
    }else{
       obj[(m,n)] = uniquePaths(m-1, n) + uniquePaths(m, n-1)
        
    }
    
    return obj[(m,n)]
    
    
};

/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    return factorial(m+n-2)/(factorial(m - 1)*factorial(n - 1));
};

let memory = {};
function factorial(n) {
    if (n < 2) return 1;
    if (memory[n] !== undefined) return memory[n];
    memory[n] = n*factorial(n-1);
    return memory[n];
}
```
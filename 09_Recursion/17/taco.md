```javascript
/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    if(digits.length == 0) return []
    
    const newArr = digits.split('');
    newArr.forEach((n, i) => {
        
        n = (n-1) * 3
        if(n == 24 || n == 18) {
            n = [n+95, n+96, n+97, n+98]
        }else if(n == 21){
            n = [n+95, n+96, n+97]
        }else{
            n = [n+94, n+95, n+96];
        }
        
        newArr.splice(i, 1, n)
    })
    
    console.log(newArr)
    let arr = []
     newArr.reduce((acc, cur) => {
        const len = acc.length;
        acc.forEach((a) => {
            cur.forEach((c) => {
                acc.push(a.toString() + c.toString())
            })
        })
        arr = acc.slice(len)
    })
    
    return arr
    
    
    
};
```
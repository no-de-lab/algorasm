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
        if(n == 18) {
            n = [n+94, n+95, n+96, n+97]
        }else if(n == 21){
            n = [n+95, n+96, n+97]
        }else if(n==24){
                 n = [n+95, n+96, n+97, n+98]
                 }else{
            n = [n+94, n+95, n+96];
        }
        
        newArr.splice(i, 1, n)
    })
    let array=[]
    newArr.map((a,i) => {
        a.map((d,j) => {
            a.splice(j, 1, String.fromCharCode(d))
        })
        
    })
    
    if(newArr.length ==1){
        return newArr[0]
    }
    let arr = []
    return newArr.reduce((acc, cur) => {
         console.log(acc)
        const len = acc.length;
        acc.forEach((a) => {
            cur.forEach((c) => {
                acc.push(a.toString() + c.toString())
            })
        })
     
        return acc.slice(len)
    })
    
 
    
    
    
};



```
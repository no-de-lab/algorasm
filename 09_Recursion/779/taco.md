```javascript
/**
 * @param {number} N
 * @param {number} K
 * @return {number}
 */

 /// ㄷㅏ시 스레기같은 코드 등장 ! runtime error
var kthGrammar = function(N, K) {
    let first = '0';
    let letters = replace(first);
    
    for(let i = 1; i<N; i++){
        letters = replace(letters)
    }
    return letters[K-1];
    
};

function replace(str){
    let arr = str.split('');
    
    arr.forEach((a, i) => {
        if(a == '0'){
            arr.splice(i, 1, '01')
        }else {
           arr.splice(i, 1, '10')
        }
    })
    
    return arr.join('');
    
    
}
```
/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    if(digits.length == 0) return []
    
    let arr = [];
    for(let i = 97; i<123;i++){
        arr.push(String.fromCharCode(i))
    }
    
    // digit의 각 요소 split 하고 각 값에서 -1 해서 * 3한 인덱스까지 알파벳 끼워넣기 
    // 2면 012 3이면 345 
    const newArr = digits.split('');
    newArr.forEach((n, i) => {
        
        n = (n-1) * 3
        if(n == 24 || n == 18) {
            n = [n-2, n-1, n, n+1]
        }else if(n == 21){
            n = [n-2, n-1, n]
        }else{
            n = [n-3, n-2, n-1];
        }
        
        newArr.splice(i, 1, n)
    })
    let anotherArr =[];
    
    
    console.log(newArr)
    

}

// function recur(another){
    
// }

```javascript
//양심없는 첫번째 코드
var tribonacci = function(n) {
    
    if(n == 0){
        return 0;
    }else if(n==1){
        return 1;
    }else if(n==2){
        return 1;
    }else if(n>2){
        return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3)
    }
};
// time exceed 뜸 35까지는 버티다가 36에서

/**
 * @param {number} n
 * @return {number}
 */
var tribonacci = function(n) {
  let tribonacciStorage = [0, 1, 1, 2];

  for (let i = 4; i <= n; i ++) {
      tribonacciStorage.push(tribonacciStorage[i - 3] + tribonacciStorage[i - 2] + tribonacciStorage[i - 1]);
  }
    
  return tribonacciStorage[n];
}

//배열로 하면 된다?


//
```
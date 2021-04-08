.......ㅎ.ㅎ.ㅎ. 
이거또한 매에에에에우 어렵네요....


```javascript
function solution(N, number) {
  let result = [];
  let answer = 0;
  
  for(var i = 1; i < 9; i++) {
    if(answer) return;
    if(i === 1) {
        // 한자리 수 예외 처리
      result.push([N]);
    } else {
      var temp = [parseInt(String(N).repeat(i))];
      var prev = result[i-2];
      for(var j = 0; j < prev.length; j++) {
        let mul = prev[j] * N;
        let div = prev[j] / N;
        let add = prev[j] + N;
        let sub = prev[j] - N;
        if( mul === number || 
            div === number || 
            add === number ||
            sub === number ) {
            answer = i;
            return answer;
        }
        temp = [ ...temp, mul, div, add, sub ];
      }
      result.push(temp);
    }
  }
  if(!answer) return answer = -1;
  return answer;
}



```
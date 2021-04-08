어렵네요..ㅎ.ㅎ



```javascript
var uniquePaths = function(m, n) {
    // 오른쪽, 왼쪽은 주어진 grid 값에서 -1 까지만 갈 수 있음 
    var r = n -1;
    var d = m - 1;
    var el = r + d; // 주어진 m,n에 따라서 r,d 과 채워 질 수 있는 수
    var result = [];

    for(let i = 0; i < el; i++) {
       // 배열안에 들어갈 수 있는 수 만큰 for 문 돌리기 
      for(let j = i+1; j < el ; j++) {
        // 조합할 수 있는 배열 채우기
        var temp = Array(el);
        temp[i] = '0';
        temp[j] = '0';
        // 총 arr 넣고
        result.push(temp);
      }
    }
    // 총 값의 length 를 뽑아내기
    return result.length;
};
```
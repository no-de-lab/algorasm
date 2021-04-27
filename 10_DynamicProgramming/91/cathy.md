풀리지 않음... 
ㅜ ㅜ...
식 짜다가 포기함... 
하아...

```javascript

const findCode = function(a, i, r, decode) {
  let code = a[i*r] + a[i*r+1];
  if(code > 26) return decode;
  if(!a[i*r+1]) return decode;
  ++decode;
  return findCode(a, i + 1, r, decode) 
}

const numDecodings = function(s) {
    // 0 이 속해있고 그 앞에 있는 수가 2보다 클 경우 어떤 경우에도 decode 조합이 될 수 없음
    // 0 이 처음 올 경우 
    if(s.indexOf("0") !== -1) {
      if(s[s.indexOf("0") - 1] > 2 || s[0] === "0") return 0;
      return 1;
    }
    // 0 이 될만한 경우를 위에서 필터링 되었기 때문에 
    // decode 의 초기값을 1 이라고 함. -> ex ) "1234"
    let decode = 1;

    // 2자리수를 가지는 것이 배열에 몇개까지 가질 수 있냐
    let g = Math.floor(s.length / 2);
    // 12 34  

    // 12 3 4
    // 1 23 4
    // 1 2 34
    
    for(let i = g; i > 0; i--) {
      decode = findCode(s, 0, i, decode);
    }

    return decode;
};

```
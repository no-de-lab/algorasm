```javascript
var numDecodings = function(s, i=0) {
    if(s[i] == '0') return 0;
    if (i >= s.length - 1) return 1;
    
    return numDecodings(s, i+1 ) + (s[i] + s[i+1] < 27?numDecodings(s, i+2 ) :0)
    
};
```
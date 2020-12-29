```javascript
/**
 * @param {string} s
 * @return {string}
 */
var makeGood = function (s) {
  const stack = new Array();

  for (let i = 0; i < s.length; i++) {
    if (stack.length && isSameCase(stack[stack.length - 1], s[i])) {
      stack.pop();
      continue;
    }
    stack.push(s[i]);
  }

  return stack.join("");
};

function isSameCase(a, b) {
  if (Math.abs(a.charCodeAt(0) - b.charCodeAt(0)) !== 32) {
    return false;
  }

  return true;
}
```

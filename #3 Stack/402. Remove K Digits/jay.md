```javascript
const removeKdigits = function (num, k) {
  let stack = new Array();

  for (let i = 0; i < num.length; i++) {
    while (stack.length && k && stack[stack.length - 1] > num[i]) {
      stack.pop();
      k--;
    }

    stack.push(num[i]);
  }

  while (k) {
    stack.pop();
    k--;
  }

  let res = stack.join("");
  while (res.charAt(0) === "0") {
    res = res.slice(1);
  }

  if (res.length == 0) {
    return "0";
  }
  return res;
};
```

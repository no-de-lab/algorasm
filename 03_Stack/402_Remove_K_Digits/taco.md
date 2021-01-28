```javascript
/**
 * @param {string} num
 * @param {number} k
 * @return {string}
 */
//12345467
var removeKdigits = function (num, k) {
  let arr = num.split("");
  let another = [];

  for (let i = 0; i < arr.length; i++) {
    if (!another.length || another[another.length - 1] <= arr[i] || k === 0) {
      another.push(arr[i]);
    } else if (
      another[another.length - 1] > arr[i] ||
      another[another.length - 1] == 0
    ) {
      another.pop();
      k--;
      i--;
    }
  }
  while (k-- > 0) another.pop();
  while (another[0] == 0 && another.length > 0) another.shift();
  return another.join("") || "0";
};
```

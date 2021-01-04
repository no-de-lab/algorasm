```javascript
/**
 * @param {string} s
 * @return {string}
 */
var makeGood = function (s) {
  let arr = [];
  while (s.length > 0) {
    if (arr.length > 0) {
      if (
        arr[arr.length - 1].toUpperCase() === s.substr(0, 1) &&
        arr[arr.length - 1] === s.substr(0, 1).toLowerCase()
      ) {
        arr.pop();
        s = s.slice(1);
      } else if (
        arr[arr.length - 1].toLowerCase() === s.substr(0, 1) &&
        arr[arr.length - 1] === s.substr(0, 1).toUpperCase()
      ) {
        arr.pop();
        s = s.slice(1);
      } else {
        arr.push(s.substr(0, 1));
        s = s.slice(1);
      }
    }

    if (arr.length == 0) {
      arr.push(s.substr(0, 1));
      s = s.slice(1);
    }
  }

  return arr.join("");
};
```

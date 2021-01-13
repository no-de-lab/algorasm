```javascript
/**
 * @param {string} s
 * @return {number}
 */
var calculate = function (s) {
  s = s.trim();
  let newA = s.split("");
  newA = newA.filter((a) => a !== " ");
  console.log(newA);
  let arr = [];

  for (let i = 0; i < newA.length; i++) {
    arr.push(newA[i]);
    if (newA[i] === "*") {
      arr.pop();
      let count = parseInt(arr[arr.length - 1], 10) * parseInt(newA[i + 1], 10);
      arr.pop();
      arr.push(count);
      newA.shift();
    } else if (newA[i] === "/") {
      arr.pop();
      let count = Math.floor(
        parseInt(arr[arr.length - 1], 10) / parseInt(newA[i + 1], 10)
      );
      arr.pop();
      arr.push(count);
      newA.shift();
    }
  }

  let anotherArr = arr;
  if (!anotherArr.includes("+") && !anotherArr.includes("-")) {
    arr = arr.join("");
    console.log(arr);
    return arr;
  }
  for (let i = 0; i < anotherArr.length; i++) {
    if (arr[1] === "+") {
      let count = parseInt(arr[0], 10) + parseInt(arr[2], 10);
      arr = arr.slice(3);
      arr.unshift(count);
    } else if (arr[1] === "-") {
      let count = parseInt(arr[0], 10) - parseInt(arr[2], 10);
      arr = arr.slice(3);
      arr.unshift(count);
    }
    if (arr.length === 1) {
      break;
    }
  }

  return arr[0];
};
```

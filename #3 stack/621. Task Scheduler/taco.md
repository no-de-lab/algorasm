```javascript
/**
 * @param {character[]} tasks
 * @param {number} n
 * @return {number}
 */
var leastInterval = function (tasks, n) {
  const len = tasks.length;
  let counts = {};
  let sameMaxNum = 0;
  //각 개수 세기
  tasks.forEach((t) => {
    counts[t] = (counts[t] || 0) + 1;
  });

  const countsArr = Object.values(counts);
  countsArr.forEach((t) => {
    if (t === Math.max(...countsArr)) {
      sameMaxNum++;
    }
  });

  const maxNum = Math.max(...countsArr);

  return Math.max((maxNum - 1) * (n + 1) + sameMaxNum, len);
};
```

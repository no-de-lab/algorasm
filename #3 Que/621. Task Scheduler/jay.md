```javascript
var leastInterval = function (tasks, n) {
  const list = new Map();
  tasks.map((alpha) => {
    if (list.get(alpha) === undefined) {
      list.set(alpha, 1);
    } else {
      list.set(alpha, list.get(alpha) + 1);
    }
  });

  list[Symbol.iterator] = function* () {
    yield [...this.entries()].sort((a, b) => b[1] - a[1]);
  };

  const sorted = list[Symbol.iterator]().next().value;

  let idle = (sorted[0][1] - 1) * n;

  for (let i = 1; i < sorted.length; i++) {
    idle = idle - Math.min(sorted[0][1] - 1, sorted[i][1]);
  }

  if (idle < 0) {
    idle = 0;
  }

  return tasks.length + idle;
};
```

```javascript
let left;
let right;
const count = function(tree, target) {
  if (tree === null) return 0;
  let l = count(tree.left, target);
  let r = count(tree.right, target);

  if (tree.val === target) {
    left = l;
    right = r;
  }
  return l + r + 1;
};

const btreeGameWinningMove = function(root, n, x) {
  count(root, x);
  // n - left -right - 1은 부모노드에서 시작했을경우이므로 반 이상이되면 승리가능
  // left나 right의 value가 반 이상이 될 경우 그 노드부터 시작하며 승리가능
  return Math.max(Math.max(left, right), n - left - right - 1) > n / 2;
};
```

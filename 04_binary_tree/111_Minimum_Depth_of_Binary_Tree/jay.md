```javascript
const minDepth = function(root) {
  const result = getMin(0, root);
  return result === Infinity ? 0 : result;
};

function getMin(depth, root) {
  depth++;
  if (!root) {
    return Infinity;
  }
  if (root.left === null && root.right === null) {
    return depth;
  }

  let leftDepth = getMin(depth, root.left);
  let rightDepth = getMin(depth, root.right);

  return Math.min(leftDepth, rightDepth);
}
```

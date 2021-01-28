```javascript
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {boolean}
 */
var hasPathSum = function (root, sum) {
  if (!root) return false;
  let queue = [root];
  while (queue.length) {
    let anotherRoot = queue.shift();
    // console.log(anotherRoot.val)
    if (anotherRoot.val === sum && !anotherRoot.left && !anotherRoot.right)
      return true;
    if (anotherRoot.left) {
      anotherRoot.left.val += anotherRoot.val;
      queue.push(anotherRoot.left);
      console.log(queue);
    }
    if (anotherRoot.right) {
      anotherRoot.right.val += anotherRoot.val;
      queue.push(anotherRoot.right);
    }
  }
  return false;
};
```

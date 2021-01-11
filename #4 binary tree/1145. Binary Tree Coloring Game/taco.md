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
 * @param {number} n
 * @param {number} x
 * @return {boolean}
 */
var btreeGameWinningMove = function(root, n, x) {
let node = searchLeaf(root, x)
   const leftOver = n-(countLeaf(node.left) + countLeaf(node.right) +1)
   const result = Math.max(leftOver, Math.max(countLeaf(node.left), countLeaf(node.right)))
return result > (n / 2)? true:false
   };

let countLeaf = (node) => {
    if(node == null){
        return 0;
    }
    let left = countLeaf(node.left)
    let right = countLeaf(node.right)
    
    return left + right + 1
}


let searchLeaf = (node, x) => {
    if(node==null)
			return null;
	if(node.val==x)
			return node;
    let left = searchLeaf(node.left, x);
    let right = searchLeaf(node.right, x);
    return left === null? right : left
}
```

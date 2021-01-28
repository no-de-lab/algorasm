언어: TypeScript

```javascript
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */


function inorderTraversal(root: TreeNode | null, array = []): number[] {
    if (!root) return array;     

    
    if(root.left) inorderTraversal(root.left, array);
    array.push(root.val);
    if(root.right) inorderTraversal(root.right, array);
    
    return array;
};
```

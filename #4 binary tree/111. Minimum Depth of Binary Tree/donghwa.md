```.java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        TreeNode tree;
        int result = 1;
        int length = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            tree = queue.poll();
            length--;
            if(tree.left == null && tree.right == null){
                return result;
            }
            if(tree.left != null)
                queue.offer(tree.left);
            if(tree.right != null)
                queue.offer(tree.right);
            if(length == 0){
                length = queue.size();
                result ++;
            }
        }
        return result;
    }
}
```

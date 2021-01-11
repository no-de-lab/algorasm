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
    int x_parent = 0;
    int x_left_child = 0;
    int x_right_child = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root, x);
        x_right_child = n-x_parent-x_left_child-1;
        if((x_parent+x_left_child < x_right_child) || (x_parent+x_right_child < x_left_child) || (x_left_child + x_right_child < x_parent))
            return true;
        return false;
    }
    void dfs(TreeNode node, int _x){
        if(node != null){
            if(node.val == _x){
                dfs_x_left(node.left);
            } else {
                x_parent++;
                dfs(node.left, _x);
                dfs(node.right, _x);
            }
        }
    }
    void dfs_x_left(TreeNode node){
        if(node != null){
            x_left_child++;
            dfs_x_left(node.left);
            dfs_x_left(node.right);
        }
    }
}
```

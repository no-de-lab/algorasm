언어: 자바


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
    List result = new LinkedList<>();
    int count = 0;
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return result;
        int count = 0;
        travelsal(root, 0);
        return result;
    }
    
    public void travelsal(TreeNode t, int depth){
        if(count <= depth) {
            result.add(t.val);
            count++;
        }
        if(t.right != null)
            travelsal(t.right, depth+1);
        if(t.left != null)
            travelsal(t.left, depth+1);
        
    }
}
```

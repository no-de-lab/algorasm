```java
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
    public boolean hasPathSum(TreeNode root, int sum) {
        // 결국 순회해서 path를 찾아야 하기 때문에
        // 재귀를 이용해서 순회하는 것이 유리하다고 생각
        // 기존 블로그에서 정리한 것을 바탕으로 순회한다.
        
        // 1. 탈출 코드(성공시, 실패시)를 만든다.
        // 2. 
        
        // 실패시 탈출코드
        if(root == null) return false;
        
        
        // 성공시 탈출코드, 끝에 도착했고, 합이 sum과 같을 때
        if(root.left == null && root.right == null && sum - root.val == 0) return true;
        
        
        // 순회, 왼쪽 우선 체크하고 빠져나오면서 실패시(false를 반환하므로), 오른쪽 체크
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
```

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
    public int minDepth(TreeNode root) {
        // BFS 너비우선탐색으로 풀기
        if(root == null) return 0; // 비었을 때
    
        int depth = 1; // 너비 라운드
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(root); // 최초에 방문할 노드를 큐에 삽입

        
        while(!q.isEmpty()){ // 빌 때까지 순환
            int size = q.size(); // 큐의 사이즈만큼 반복
            // for each level
            for(int i=0;i<size;i++){
                // 방문할 최초 노드의 값을 큐에서 꺼내고, 큐와 인접해 있는 노드들을 큐에 삽입
                TreeNode node = q.poll(); 

                if(node.left == null && node.right == null){ // 인접노드가 없으면?
                    return depth;
                }
                if(node.left != null){ // 왼쪽 노드가 있으면?
                    q.offer(node.left);
                }
                if(node.right != null){ // 오른쪽 노드가 있으면?
                    q.offer(node.right);
                }
            }
            // 다음 너비 라운드
            depth++;
        }
        return depth;
    }
}
```

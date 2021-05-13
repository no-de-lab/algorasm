```javascript
var diameterOfBinaryTree = function(root) {
    if(root == null) return 0;
    let max = -Infinity;
   function dfs(root){
    if(!root) return 0;
    
    const left = dfs(root.left);
    const right = dfs(root.right);
    max = Math.max(max, left+right)
    return Math.max(left, right) +1
    
}
    
    dfs(root)
    return max;
    
    
};
```
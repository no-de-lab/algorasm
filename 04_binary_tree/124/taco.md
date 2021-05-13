https://leetcode.com/problems/binary-tree-maximum-path-sum/
```javascript
var maxPathSum = function(root) {
    let max = -Infinity;
    
    function max_sum(node){
        if(!node) return 0;
        
        let right = Math.max(0, max_sum(node.right));
        let left = Math.max(0, max_sum(node.left));
        max = Math.max(max, left+right+node.val )
        return node.val + Math.max(left, right)
    }
    max_sum(root)
    return max
    
};
```
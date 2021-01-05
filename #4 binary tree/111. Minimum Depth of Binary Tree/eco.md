언어 : TypeScript

recursive 활용한 알고리즘 설게에 매우 취약합니다 ㅠ
정답 코드로 학습한 후 올립니다.

``` typescript
function minDepth(root: TreeNode | null): number {
    if (root === null) return 0;
    // leaf Node 인 경우 0 을 return 하므로 0 에서부터 depth 마다 +1 해줌.
    
    if (root.left === null) return minDepth(root.right) + 1;
    if (root.right === null) return minDepth(root.left) + 1;
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
};
```

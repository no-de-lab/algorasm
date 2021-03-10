언어: typescript

```typescript
function rightSideView(root: TreeNode | null): number[] {
    const nodes: number[] = [];
    traversalNode(root, 1, nodes);
    return nodes;
};

function traversalNode(node: TreeNode| null, depth: number, nodes: number[]): void {
    if (!node) {
        return;
    }

    if (!nodes[depth - 1]) {
        nodes.push(node.val);
    }

    depth++;
    traversalNode(node.right, depth, nodes);
    traversalNode(node.left, depth, nodes);
}
```

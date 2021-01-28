/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var middleNode = function(head) {
    const { length } = traverse(head);
    const middleIndex = length % 2 === 0
                        ? length / 2 + 1
                        : Math.round(length / 2);
    const { node } = traverse(head, middleIndex);
    return node;
};

function traverse(node, lastIndex, curIndex = 1) {
    if (node === null || curIndex === lastIndex) {
        return { 
            node: node,
            length: curIndex - 1
        };
    }
    traverse(node.next, lastIndex, curIndex + 1);
}
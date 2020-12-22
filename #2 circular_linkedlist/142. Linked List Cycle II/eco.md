언어 : JS

시간 복잡도 : O(N)

```javascript
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
const detectCycle = function(head) {
    let current = head;
    const memo = new Map();
    while (true) {
        if (current === null) return null;
        if (memo.has(current)) return current;
        memo.set(current, true);
        current = current.next;
    }
};
```
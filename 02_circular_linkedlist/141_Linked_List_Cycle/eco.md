언어 : JavaScript

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
 * @return {boolean}
 */

// 공간 복잡도 O(N)
const hasCycle = function(head) {
    if (head === null) return false;
    const memo = new Map();
    let current = head;
    while (true) {
        if (current === null) return false;
        if (memo.has(current)) return true;
        memo.set(current, true);
        current = current.next;
    }
};

// 공간 복잡도 O(1)
const hasCycle = function (head) {
    if (head === null) return false;
    let oneStep = head;
    let twoStep = head?.next;
    while (true) {
        if (oneStep === twoStep) return true;
        if (!twoStep) return false;
        oneStep = oneStep.next;
        twoStep = twoStep.next?.next;
    }
}
```
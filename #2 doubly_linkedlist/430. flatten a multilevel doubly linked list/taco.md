```javascript
/**
 * // Definition for a Node.
 * function Node(val,prev,next,child) {
 *    this.val = val;
 *    this.prev = prev;
 *    this.next = next;
 *    this.child = child;
 * };
 */

/**
 * @param {Node} head
 * @return {Node}
 */
var flatten = function (head) {
  let newHead = head;
  while (newHead !== null) {
    if (newHead.child !== null) {
      let newChild = flatten(newHead.child);
      newHead.child = null;
      let newNext = newHead.next;
      newHead.next = newChild;
      newChild.prev = newHead;
      while (newChild.next !== null) {
        newChild = newChild.next;
      }
      newChild.next = newNext;
      if (newNext !== null) {
        newNext.prev = newChild;
      }
      newHead = newNext;
    } else {
      newHead = newHead.next;
    }
  }

  return head;
};
```

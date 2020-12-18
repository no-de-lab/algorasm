언어 : javascript

시간복잡도 : O(N)

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
const flatten = function (head) {
  if (head === null) return head;

  (function recursive(head) {
    let node = head;
    while (node.next !== null || node.child) {
      if (node.child) {
        const temp = node.next;
        node.next = node.child;
        node.child.prev = node;

        const child = node.child;
        node.child = null;

        const tail = recursive(child);

        if (temp) {
          tail.next = temp;
          temp.prev = tail;
          node = temp;
        }
        continue;
      }
      node = node.next;
    }
    return node;
  })(head);

  return head;
};
```

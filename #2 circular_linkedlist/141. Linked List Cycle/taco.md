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
var hasCycle = function (head) {
  //만약 계속 반복해서 돌아가면 cycle이 있는 것이다.
  // head 3012012012012012
  let arr = [];
  while (head != null) {
    if (arr.includes(head)) {
      return true;
    } else {
      arr.push(head);
    }
    head = head.next;
  }
  return false;
};
```

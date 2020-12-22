언어 : javascript

시간복잡도 : O(N)

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
var detectCycle = function (head) {
  // 빈 객체가 들어왔을 테스트 케이스
  if (head == null) return null;

  while (head != null) {
    if (head.visited) return head;
    head.visited = true;
    head = head.next;
  }
  return null;
};

```

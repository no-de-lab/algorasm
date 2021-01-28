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
 * @return {boolean}
 */
var hasCycle = function (head) {
    // 빈 객체가 들어왔을 테스트 케이스
  if (head == null) return false;

  while (head != null) {
    if (head.visited) return true;
    head.visited = true;
    head = head.next;
  }
  return false;
};
```

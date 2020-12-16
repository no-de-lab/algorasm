###### 단순 연결 리스트 92. Reverse Linked List II

```

var reverseBetween = function(head, m, n) {
    /**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} m
 * @param {number} n
 * @return {ListNode}
 */
var reverseBetween = function(head, m, n) {
    if (head === null) return head;

    const dummy = new ListNode(0);
    dummy.next = head;

    let cur = head;
    let prev = dummy;
    for(let i = 1; i<m; i++){
        cur = cur.next; //2345
        prev = prev.next //12345
    }

    for(let j = m; j<n; j++){
        let temp = cur.next;
        cur.next = temp.next;
        temp.next =prev.next;
        prev.next = temp
    }
    return dummy.next
};
};
```

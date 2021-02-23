```javascript
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    if(!l1 && !l2) return null;
    if(l1 && !l2) return l1;
    if(!l1 && l2) return l2;
    
    if(l1.val < l2.val){
        const l3 = new ListNode(l1.val);
        l3.next = mergeTwoLists(l1.next, l2);
        return l3
    }else {
        const l3 = new ListNode(l2.val);
        l3.next = mergeTwoLists(l1, l2.next);
        return l3
    }
       
    
  
};
```
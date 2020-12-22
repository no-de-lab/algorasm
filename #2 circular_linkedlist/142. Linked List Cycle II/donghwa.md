```.java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> nodeSet = new HashSet<>();
        while(head != null){
            if(nodeSet.contains(head))
                return head;
            else
                nodeSet.add(head);
            head = head.next;
        }
        return null;
    }
}
```

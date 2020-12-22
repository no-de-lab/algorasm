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
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> nodeSet = new HashSet<>();
        int size = 0;
        while(head != null){
            if(nodeSet.contains(head))
                return true;
            else
                nodeSet.add(head);
            head = head.next;
        }
        
        return false;
    }
}
```

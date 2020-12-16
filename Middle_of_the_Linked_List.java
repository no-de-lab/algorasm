/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode result = head;
        int turn = 0;
        while(head != null){
            turn++;
            if(turn%2 == 0)
                result = result.next;
            head = head.next;     
        }
        return result;
    }
}

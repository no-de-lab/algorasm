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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev_m_node = new ListNode();
        ListNode m_node = new ListNode();
        ListNode cur_node = head;
        ListNode prev_node = new ListNode();
        ListNode temp = new ListNode();
        for(int num=1; num<=n; num++){
            if(num<=m){
                if(num==m-1){
                    prev_m_node = cur_node;
                }
                if(num==m){
                    m_node = cur_node;
                }
                prev_node = cur_node;
                cur_node = cur_node.next;
            }
            else{
                temp = cur_node.next;
                cur_node.next = prev_node;
                prev_node = cur_node;
                cur_node = temp;
                if(num==n){
                    prev_m_node.next = prev_node;
                    m_node.next = cur_node;
                }
                if(m == 1)
                    head = prev_node;
            }
        }
        return head;
    }
}

/**
 * 런타임 0ms / 메모리 36.3MB
 * 일단 Node next를 순회하면서 전체 카운트를 확인한 후 cnt / 2를 하고나서 나머지를 버리면 해당 배열요소에 바로 맞게 답이 나옵니당
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution3 {
    public ListNode middleNode(ListNode head) {
        int index = getTargetIndex(head);

        return getTargetNode(head, index);
    }

    private int getTargetIndex(ListNode head) {
        int cnt = 0;
        while (head != null) {
            head = head.next;
            cnt++;
        }

        return (int) Math.floor(cnt / 2);
    }

    private ListNode getTargetNode(ListNode head, int index) {
        for(int i = 0; i < index; i++) {
            head = head.next;
        }

        return head;
    }
}
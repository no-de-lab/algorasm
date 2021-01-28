/**
 * 문제 접근을 잘못한거같아서 포기했습니다 ㅜ
 * 재귀, backtracking으로 푸는거 같은데 middle 문제 난이도도 상당하네요 :(
 * 조금씩 보다가 제출기한 이전에 이해가 되면 다시 풀어서 제출하겠습니다 ㅜ
 */
public class ReverseLinkedList2 {

    /*
    static class ListNode {
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

    static class Solution4 {
        public ListNode getListNode(ListNode head, int m, int n) {
            ListNode mPreNode = null;
            ListNode mNode = null;
            ListNode mAfterNode = null;
            ListNode nPreNode = null;
            ListNode nNode = null;
            ListNode nAfterNode = null;

            m = m - 1;
            n = n - 1;

            int size = size(head);

            if (!isOutBounds(size, m)) {
                mPreNode = getNode(head, m - 1);
                mNode = mPreNode.next;
                mAfterNode = mNode.next;
            } else {
                if (isOutPreBounds(size)) {
                    mNode = getNode(head, m);
                    mAfterNode = mNode.next;
                } else {
                    mPreNode = getNode(head, m - 1);
                    mNode = mPreNode.next;
                }
            }

            if (!isOutBounds(size, n)) {
                nPreNode = getNode(head, n - 1);
                nNode = nPreNode.next;
                nAfterNode = nNode.next;
            } else {
                if (isOutPreBounds(size)) {
                    nNode = getNode(head, n);
                    nAfterNode = nNode.next;
                } else {
                    nPreNode = getNode(head, n - 1);
                    nNode = mPreNode.next;
                }
            }

        }

        private boolean isOutBounds(int size, int index) {
            if(isOutPreBounds(index)) {
                return true;
            }

            if(isOutAfterBounds(size, index)) {
                return true;
            }

            return false;
        }

        private boolean isOutPreBounds(int index) {
            if (index == 0) {
                return true;
            }

            return false;
        }

        private boolean isOutAfterBounds(int arraySize, int index) {
            if (arraySize - 1 == index) {
                return true;
            }

            return false;
        }

        private int size(ListNode head) {
            int cnt = 0;
            while (head != null) {
                head = head.next;
                cnt++;
            }
            return cnt;
        }

        private ListNode getNode(ListNode head, int index) {
            for (int i = 0; i < index; i++) {
                head = head.next;
            }

            return head;
        }
    }*/

    class Solution {

        // Object level variables since we need the changes
        // to persist across recursive calls and Java is pass by value.
        private boolean stop;
        private ListNode left;

        public void recurseAndReverse(ListNode right, int m, int n) {

            // base case. Don't proceed any further
            if (n == 1) {
                return;
            }

            // Keep moving the right pointer one step forward until (n == 1)
            right = right.next;

            // Keep moving left pointer to the right until we reach the proper node
            // from where the reversal is to start.
            if (m > 1) {
                this.left = this.left.next;
            }

            // Recurse with m and n reduced.
            this.recurseAndReverse(right, m - 1, n - 1);

            // In case both the pointers cross each other or become equal, we
            // stop i.e. don't swap data any further. We are done reversing at this
            // point.
            if (this.left == right || right.next == this.left) {
                this.stop = true;
            }

            // Until the boolean stop is false, swap data between the two pointers
            if (!this.stop) {
                int t = this.left.val;
                this.left.val = right.val;
                right.val = t;

                // Move left one step to the right.
                // The right pointer moves one step back via backtracking.
                this.left = this.left.next;
            }
        }

        public ListNode reverseBetween(ListNode head, int m, int n) {
            this.left = head;
            this.stop = false;
            this.recurseAndReverse(head, m, n);
            return head;
        }
    }

}

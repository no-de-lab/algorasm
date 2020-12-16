import java.util.Arrays;
import java.util.Comparator;

/**
 * 런타임 10ms / 메모리 41.8MB
 * 짜고나서 보니까 많이 더럽네요 :(
 * 스터디원분들 코드 염탐하러 가겠습니다 ㅜ
 * stream으로 arr[][0]에 있는 인자 기준으로 일단 정렬을 해줬어요!
 * 그 후에 intervalStructure에서 Node들을 더할때 마다 중복되는지 체크를 한 후 넣어주는 식으로 작성했습니다~
 */

class Solution2 {
    public int[][] merge(int[][] intervals) {
        int[][] ascIntervals = Arrays.stream(intervals)
                .sorted(Comparator.comparingInt(arr -> arr[0]))
                .toArray(int[][]::new);

        intervalStructure intervalStructure = new intervalStructure();

        for (int i = 0; i < ascIntervals.length; i++) {
            intervalStructure.addNode(ascIntervals[i]);
        }

        intervals = intervalStructure.toIntArray();
        return intervals;
    }
}

class intervalStructure {

    Node head;
    Node tail;
    int size;

    class Node{
        int pre;
        int after;
        Node next;
        Node preNode;

        public Node(int pre, int after) {
            this.pre = pre;
            this.after = after;
            next = null;
            preNode = null;
        }
    }

    public void addNode(int[] data) {
        Node newNode = new Node(data[0], data[1]);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            if(checkDuplicates(tail, newNode)) {
                Node mergeNode = mergeNode(tail, newNode);
                if(head == tail) {
                    head = mergeNode;
                    tail = mergeNode;
                    return;
                }
                Node preNode = tail.preNode;
                preNode.next = mergeNode;
                tail = mergeNode;
                tail.preNode = preNode;
                return;
            }
            Node preNode = tail;
            tail.next = newNode;
            tail = newNode;
            tail.preNode = preNode;
        }
        size++;
    }

    private boolean checkDuplicates(Node n1, Node n2) {
        if(n1.after >= n2.pre) {
            return true;
        }

        return false;
    }

    private Node mergeNode(Node n1, Node n2) {
        int after = (n1.after > n2.after) ? n1.after : n2.after;
        return new Node(n1.pre, after);
    }

    public void displayNodes() {
        Node n = head;
        while(n != null) {
            System.out.println("[" + n.pre + "," + n.after + "]");
            n = n.next;
        }
    }

    public int[][] toIntArray() {
        int[][] nums = new int[size][2];

        Node n = head;
        int i = 0;
        while(n != null) {
            nums[i][0] = n.pre;
            nums[i][1] = n.after;
            n = n.next;
            i++;
        }

        return nums;
    }
}
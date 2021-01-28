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
    const linkedList = new LinkedList(head);
    return linkedList.reverse(m, n);
};

class LinkedList {
    constructor(head) {
        this.head = head;
    }
    
    traverseToIndex(index) {
        let counter = 1;
        let currentNode = this.head;
        while(counter !== index && currentNode.next !== null) {
            currentNode = currentNode.next;
            counter++;
        }
        return currentNode;
    }
    
    reverse(m, n) {
        if(!this.head.next) return this.head;
        
        // 고정 변수 선언
        const saved = {
            beforeStart: undefined, // reverse 시작 노드보다 하나 이전 노드
            start: undefined,       // reverse 시작 노드
            end: undefined,         // reverse 마지막 노드
            afterEnd: undefined,    // reverse 마지막 노드보다 하나 다음 노드
        };

        saved.end = this.traverseToIndex(n);
        saved.afterEnd = saved.end.next;

        // reverse 를 head 노드부터 할 때와 그렇지 않을 때의 변수를 달리 선언해준다.
        if (m === 1) {
            saved.start = this.head;
        } else if (m > 1) {
            saved.beforeStart = this.traverseToIndex(m - 1);
            saved.start = saved.beforeStart.next;
        }
        
        // 임시 pointer 선언 및 reverse
        let left = saved.start;
        let right = saved.start.next;
        while(right !== saved.afterEnd) {
            const temp = right.next;
            right.next = left;
            left = right;
            right = temp;
        }
        
        // reverse 를 head 노드부터 할 때와 그렇지 않을 때, 기존 노드와의 연결 방법이 다르다.
        if (m === 1) {
            this.head = saved.end; // head 변경
        } else if (m > 1) {
            saved.beforeStart.next = saved.end; // reverse 영역 이전 노드와 reverse 된 노드 연결
        }
        
        saved.start.next = saved.afterEnd;  // reverse 된 노드와 reverse 영역 다음 노드 연결

        return this.head;
    }
}
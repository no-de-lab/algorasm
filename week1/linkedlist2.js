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
        this.tail = this.traverseToIndex();
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
        
        let start = this.traverseToIndex(m - 1);
        let end = this.traverseToIndex(n);
        
        let first = start.next;
        let second = start.next.next;
        
        
        
        while(second !== end.next) {
            const temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }
        
        start.next = end;
        end.next = start;
        return head;
    }
}
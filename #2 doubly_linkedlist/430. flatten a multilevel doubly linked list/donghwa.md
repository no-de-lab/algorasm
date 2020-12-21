/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Stack<Node> saveNode = new Stack<>();
        Node curNode = head;
        while(curNode != null){
            if(curNode.child !=null ){
                if(curNode.next != null)
                    saveNode.push(curNode.next);
                curNode.child.prev = curNode;
                curNode.next = curNode.child;
                curNode.child = null;
            }
            else if(curNode.next == null && !saveNode.empty()){
                Node temp = saveNode.peek();
                saveNode.pop();
                curNode.next = temp;
                temp.prev = curNode;
            }
            curNode = curNode.next;
        }
        return head;
    }
}

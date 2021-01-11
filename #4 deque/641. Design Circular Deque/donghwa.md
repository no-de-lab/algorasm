```.java
class MyCircularDeque {
    Node front;
    Node rear;
    int full = 0;
    int size = 0;
    
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        full = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull())
            return false;
        Node node = new Node(value);
        if(front == null && rear == null){
            front = node;
            rear = node;
        } else {
            node.next = front;
            front.prev = node;
            front = node;
        }
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull())
            return false;
        Node node = new Node(value);
        if(front == null && rear == null){
            front = node;
            rear = node;
        } else {
            rear.next = node;
            node.prev = rear;
            rear = node;
        }
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty())
            return false;
        if(front == rear){
            front = null;
            rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty())
            return false;
        if(front == rear){
            front = null;
            rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return size>0? front.val : -1;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return size>0? rear.val : -1;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size==full;
    }
}

class Node {
    int val;
    Node prev;
    Node next;
    Node(int val){
        this.val = val;
    }
}
/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
```

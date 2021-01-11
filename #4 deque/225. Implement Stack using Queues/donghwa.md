```.java
class MyStack {
    Queue<Integer> queue1, queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(queue1.size()>1)
            queue2.add(queue1.remove());
        int result = queue1.remove();
        Queue<Integer> t = new LinkedList<>();
        t = queue1;
        queue1 = queue2;
        queue2 = t;
        return result;
    }
    
    /** Get the top element. */
    public int top() {
        while(queue1.size()>1)
            queue2.add(queue1.remove());
        int result = queue1.remove();
        queue2.add(result);
        Queue<Integer> t = new LinkedList<>();
        t = queue1;
        queue1 = queue2;
        queue2 = t;
        return result;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
```

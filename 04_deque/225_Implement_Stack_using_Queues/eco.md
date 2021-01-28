```javascript
/**
 * Initialize your data structure here.
 */
class MyStack {
  constructor() {
    this.stack = [];
  }
  /**
   * Push element x onto stack.
   * @param {number} x
   * @return {void}
   */
  push(x) {
    this.stack.push(x);
  }

  /**
   * Removes the element on top of the stack and returns that element.
   * @return {number}
   */
  pop() {
    return this.stack.pop();
  }

  /**
   * Get the top element.
   * @return {number}
   */
  top() {
    return this.stack[this.stack.length - 1];
  }

  /**
   * Returns whether the stack is empty.
   * @return {boolean}
   */
  empty() {
    return this.stack.length === 0;
  }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = new MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
```

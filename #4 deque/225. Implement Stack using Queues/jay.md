```javascript
const MyStack = function() {
  this.first = null;
  this.last = null;
  this.length = 0;
};
/**

 Push element x onto stack.
 @param {number} x
 @return {void}
 */
MyStack.prototype.push = function(x) {
  const newNode = {
    x: x,
    next: null,
  };
  if (this.length === 0) {
    this.first = newNode;
    this.last = newNode;
  } else {
    this.last.next = newNode;
    this.last = newNode;
  }
  this.length++;
};
/**

 Removes the element on top of the stack and returns that element.
 @return {number}
 */
MyStack.prototype.pop = function() {
  if (!this.first) {
    return null;
  }
  if (this.first === this.last) {
    this.last = null;
  }
  let currentNode = this.first;
  let holdingNode = this.first;
  while (currentNode.next !== null) {
    holdingNode = currentNode;
    currentNode = currentNode.next;
  }
  this.last = holdingNode;
  this.last.next = null;
  this.length--;
  return currentNode.x;
};
/**

 Get the top element.
 @return {number}
 */
MyStack.prototype.top = function() {
  return this.last.x;
};
/**

 Returns whether the stack is empty.
 @return {boolean}
 */
MyStack.prototype.empty = function() {
  if (this.length === 0) {
    return true;
  }
  return false;
};

```

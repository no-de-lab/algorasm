```javascript
/**
 * Initialize your data structure here. Set the size of the deque to be k.
 * @param {number} k
 */

var MyCircularDeque = function (k) {
  this.size = k + 1;
  this.front = 0;
  this.rear = 0;
  this.deque = [];
};

/**
 * Adds an item at the front of Deque. Return true if the operation is successful.
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertFront = function (value) {
  if (this.isFull()) return false;

  if (this.front === 0) {
    this.front = this.size - 1;
  } else {
    this.front = this.front - 1;
  }
  this.deque[(this.front + 1) % this.size] = value;

  return true;
};

/**
 * Adds an item at the rear of Deque. Return true if the operation is successful.
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertLast = function (value) {
  if (this.isFull()) return false;

  this.rear = (this.rear + 1) % this.size;
  this.deque[this.rear] = value;

  return true;
};

/**
 * Deletes an item from the front of Deque. Return true if the operation is successful.
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteFront = function () {
  if (this.isEmpty()) return false;

  this.front = (this.front + 1) % this.size;
  return true;
};

/**
 * Deletes an item from the rear of Deque. Return true if the operation is successful.
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteLast = function () {
  if (this.isEmpty()) return false;
  if (this.rear === 0) {
    this.rear = this.rear - 1 + this.size;
  } else {
    this.rear = (this.rear - 1) % this.size;
  }
  return true;
};

/**
 * Get the front item from the deque.
 * @return {number}
 */
MyCircularDeque.prototype.getFront = function () {
  if (!this.isEmpty()) {
    return this.deque[(this.front + 1) % this.size];
    console.log(this.deque);
  } else {
    return -1;
  }
};

/**
 * Get the last item from the deque.
 * @return {number}
 */
MyCircularDeque.prototype.getRear = function () {
  if (!this.isEmpty()) {
    return this.deque[this.rear];
  } else {
    return -1;
  }
};

/**
 * Checks whether the circular deque is empty or not.
 * @return {boolean}
 */
MyCircularDeque.prototype.isEmpty = function () {
  return this.rear === this.front ? true : false;
};

/**
 * Checks whether the circular deque is full or not.
 * @return {boolean}
 */
MyCircularDeque.prototype.isFull = function () {
  return (this.rear + 1) % this.size === this.front ? true : false;
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = new MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */
```

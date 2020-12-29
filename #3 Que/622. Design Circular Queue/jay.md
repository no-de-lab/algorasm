```javascript
/**
 * @param {number} k
 */
var MyCircularQueue = function (k) {
  this._size = k;
  this._list = [];
};

/**
 * @param {number} value
 * @return {boolean}
 */

MyCircularQueue.prototype.enQueue = function (value) {
  if (this.isFull()) {
    return false;
  }

  this._list.push(value);
  return true;
};

/**
 * @return {boolean}
 */
MyCircularQueue.prototype.deQueue = function () {
  if (this.isEmpty()) {
    return false;
  }

  this._list.splice(0, 1);
  return true;
};

/**
 * @return {number}
 */
MyCircularQueue.prototype.Front = function () {
  if (this.isEmpty()) {
    return -1;
  }

  return this._list[0];
};

/**
 * @return {number}
 */
MyCircularQueue.prototype.Rear = function () {
  if (this.isEmpty()) {
    return -1;
  }

  return this._list[this._list.length - 1];
};

/**
 * @return {boolean}
 */
MyCircularQueue.prototype.isEmpty = function () {
  if (this._list.length === 0) {
    return true;
  }

  return false;
};

/**
 * @return {boolean}
 */
MyCircularQueue.prototype.isFull = function () {
  if (this._size === this._list.length) {
    return true;
  }

  return false;
};
```

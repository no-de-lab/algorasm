언어 : JavaScript

못 풀겠습니다.. ㅠ  

```javascript
const inputArray = require('fs').readFileSync('/dev/stdin').toString().split('\n');
// const inputArray = ['4 3', 'A 2 1'];

class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}  

// doubly linked list 생성
const length = inputArray[0].split(' ')[0];
let head = new Node(1);
let tail;
let prev = head;
for (let i = 2; i <= length; i++) {
    const current = new Node(i);
    current.prev = prev;
    prev.next = current;
    prev = current;
    if (i === length) tail = current;
}

// 연산
for (let i = 1; i < inputArray.length; i++) {
    const expression = inputArray[i].split(' ');
    const type = expression[0];
    const from = expression[1];
    const to = expression[2];

    
}

function move (from, to, head = head) {
    
}
```
###### 단순 연결 리스트 876. Middle of the Linked List

```

let middleNode = function(head) {
    let targetLen = Math.ceil(getLen(head)/2);
    return returnAtPosition(head, targetLen);
};

let getLen = function(node) {
    let length = 0;
    while(node.next) {
        length += 1;
        node = node.next;
    }
    return length;
};

let returnAtPosition = function(node, targetLen) {
    for(let i = 0; i < targetLen; i++) {
        node = node.next;
    }
    return node;

```

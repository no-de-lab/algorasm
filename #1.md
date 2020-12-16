## taco

###### 배열 189. Rotate Array

```
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
  const newNums = nums.splice(nums.length-k, k);
    nums.unshift(...newNums)


//     for(let i = 0; i<k; i++){
//        nums.unshift(nums.pop())
//     }


};
```

###### 배열 56. Merge Intervals

```
/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
   const merging = (acc, cur) =>
   (!acc.length || acc[acc.length - 1][1] < cur[0] ? acc.push(cur) :
                                  acc[acc.length - 1][1] = Math.max(acc[acc.length-1][1], cur[1]),acc)

   return intervals.sort((a,b) => a[0] - b[0]).reduce(merging,[]);

}
```

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

###### 단순 연결 리스트 92. Reverse Linked List II

```
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
    if (head === null) return head;

    const dummy = new ListNode(0);
    dummy.next = head;

    let cur = head;
    let prev = dummy;
    for(let i = 1; i<m; i++){
        cur = cur.next; //2345
        prev = prev.next //12345
    }

    for(let j = m; j<n; j++){
        let temp = cur.next;
        cur.next = temp.next;
        temp.next =prev.next;
        prev.next = temp
    }
    return dummy.next
};
};
```

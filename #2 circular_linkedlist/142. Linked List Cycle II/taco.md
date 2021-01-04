```javascript
let arr = [];
if (head === null || head.next === null) {
  return null;
}
while (head !== null) {
  if (arr.includes(head)) {
    return head;
  } else {
    arr.push(head);
  }
  head = head.next;
}

return head;
```

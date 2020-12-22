언어 : javascript

실행 결과 : 런타임 에러<br>
테스트케이스는 문제가 없는데 😂<br>
javascript로 첫 백준 문제 푼것에 의의를!...
~~~javascript 
   const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
   const firstLine = input[0].split(" ");
   const n = firstLine[0];
   const m = firstLine[1];
   const methods = [];
   const targetNodes = [];
   const moveTargets = [];
   const initArray = [];
   
   class doubleLinkedList {
     constructor() {
       this._head = null;
       this._tail = null;
       this._size = 0;
     }
   
     addNode(pos) {
       const newNode = new Node(pos);
       const prev = this._tail;
       if (prev) {
         prev.setNext(newNode);
         newNode.setPrev(prev);
         this._tail = newNode;
         this._size++;
       } else {
         this._head = newNode;
         this._tail = newNode;
         this._size++;
       }
     }
   
     getNode(pos) {
       if (pos > this._size) {
         throw new Error("out of bounds");
       }
   
       let node = this._head;
   
       for (let i = 1; i < pos; i++) {
         node = node._next;
       }
   
       return node;
     }
   
     findByData(data) {
       let node = this._head;
   
       if (!this.isEmpty()) {
         while (node != null) {
           if (node.getData() == data) {
             return node;
           }
           node = node._next;
         }
       }
   
       return node;
     }
   
     insert(data, node) {
       const target = this.findByData(data);
       if (target) {
         target.insertNext(node);
       }
   
       if (target === this._tail) {
         this._tail = node;
       }
     }
   
     preInsert(data, node) {
       const target = this.findByData(data);
   
       if (target) {
         target.insertPrev(node);
       }
   
       if (target === this._head) {
         this._head = node;
       }
     }
   
     remove(data) {
       const target = this.findByData(data);
   
       if (target) {
         target.deleteNode();
       }
     }
   
     isEmpty() {
       return this._head ? false : true;
     }
   
     display() {
       if (this.isEmpty()) {
         console.log("Empty List");
       } else {
         const data = [];
         let node = this._head;
         while (node != null) {
           data.push(node.getData());
           node = node._next;
         }
         console.log(data);
       }
     }
   
     getDatas() {
       if (this.isEmpty()) {
         return [];
       } else {
         const data = [];
         let node = this._head;
         while (node != null) {
           data.push(node.getData());
           node = node._next;
         }
         return data;
       }
     }
   
     deleteNode(node) {
       if (node) {
         if (node === this._head) {
           this._head = this._head._next;
         } else if (node === this._tail) {
           this._tail = this._tail._prev;
         }
         node.deleteNode();
       }
     }
   }
   
   class Node {
     constructor(val) {
       this._data = val;
       this._next = null;
       this._prev = null;
     }
   
     setNext(node) {
       this._next = node;
     }
   
     setPrev(node) {
       this._prev = node;
     }
   
     getNext() {
       return this._next;
     }
   
     getPrev() {
       return this._prev;
     }
   
     getData() {
       return this._data;
     }
   
     insertNext(node) {
       if (node !== null) {
         const nextNode = this._next;
         node._prev = this;
         if (nextNode) {
           nextNode._prev = node;
           node._next = nextNode;
         }
         this._next = node;
         node.setPrev(this);
       }
     }
   
     insertPrev(node) {
       if (node !== null) {
         const prevNode = this._prev;
         if (prevNode) {
           prevNode._next = node;
           node._prev = prevNode;
         }
         this._prev = node;
         node.setNext(this);
       }
     }
   
     deleteNode() {
       if (this._prev) {
         this._prev._next = this._next;
       }
   
       if (this._next) {
         this._next._prev = this._prev;
       }
   
       this._next = null;
       this._prev = null;
   
       return this;
     }
   }
   
   const list = new doubleLinkedList();
   
   for (let i = 0; i < m; i++) {
     const line = input[i + 1];
     const lineData = line.split(" ");
     methods.push(lineData[0]);
     targetNodes.push(lineData[1]);
     moveTargets.push(lineData[2]);
   }
   
   for (let i = 0; i < n; i++) {
     list.addNode(i + 1);
     initArray.push(i + 1);
   }
   
   for (let i = 0; i < methods.length; i++) {
     const method = methods[i];
     const targetData = targetNodes[i];
     const moveTargetData = moveTargets[i];
   
     const node = list.findByData(targetData);
     if (node) {
       list.deleteNode(node);
       if (method === "A") {
         list.preInsert(moveTargetData, node);
       } else if (method === "B") {
         list.insert(moveTargetData, node);
       }
     }
   }
   
   const replace1 = [];
   const replace2 = [];
   const datas = list.getDatas();
   
   for (let i = 0; i < datas.length - 1; i++) {
     const index = datas.findIndex((el) => el === i + 1);
     if (index !== i) {
       replace1.push(i + 1);
       datas.splice(index, 1);
       datas.splice(i, 0, i + 1);
       replace2.push(datas[i + 1]);
     }
   }
   console.log(replace1.length);
   for (let i = 0; i < replace1.length; i++) {
     console.log("A " + replace1[i] + " " + replace2[i]);
   }
~~~

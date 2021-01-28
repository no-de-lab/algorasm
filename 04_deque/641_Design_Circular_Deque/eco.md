언어 : TypeScript

Circular Singly Linked-list 구조로 구현해 데이터 조작 시간 효율 높임

```typescript
/*
MyCircularDeque(k): Constructor, set the size of the deque to be k.
insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
getRear(): Gets the last item from Deque. If the deque is empty, return -1.
isEmpty(): Checks whether Deque is empty or not. 
isFull(): Checks whether Deque is full or not.
*/

class MyNode {
    val: number;
    next: MyNode | null;

    constructor(val: number) {
        this.val = val;
        this.next = null;
    }
}

class MyCircularDeque {
    private length: number;
    private maxLength: number;
    private tail: MyNode | null;

    constructor(k: number) {
        this.tail = null;
        this.length = 0;
        this.maxLength = k;
    }

    private insertFirstNode(node: MyNode){
        this.tail = node;
        this.tail.next = node;
    }

    public insertFront(value: number): boolean {
        if(this.length === this.maxLength) return false;

        const newNode = new MyNode(value);
        if (!this.tail) {
            this.insertFirstNode(newNode);
        } else {
            newNode.next = this.tail.next;
            this.tail.next = newNode;
        }
        this.length++;
        return true;
    }

    public insertLast(value: number): boolean {
        if (this.length === this.maxLength) return false;

        const newNode = new MyNode(value);
        if (!this.tail) {
            this.insertFirstNode(newNode);
        } else {
            newNode.next = this.tail.next;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
        return true;
    }

    public deleteFront(): boolean {
        if (!this.tail) return false;

        if (this.length === 1) {
            this.tail.next = null;
            this.tail = null;
        } else if (this.length > 1) {
            const temp = this.tail!.next!.next;
            this.tail!.next!.next = null;
            this.tail!.next = temp;
        }
        this.length--;
        return true;
    }

    public deleteLast(): boolean {
        if (!this.tail) return false;

        if (this.length === 1) {
            this.tail.next = null;
            this.tail = null;
        } else if (this.length > 1) { // 9 7 0 3
            let count: number = 0;
            let temp: MyNode = this.tail;
            while (count < this.length - 1) {
                count++;
                temp = temp.next as MyNode;
            }
            temp.next = this.tail.next;
            this.tail.next = null;
            this.tail = temp;
        }
        this.length--;
        return true;
    }

    public getFront(): number {
        return this.tail?.next?.val ?? -1;
    }

    public getRear(): number {
        return this.tail?.val ?? -1;
    }

    public isEmpty(): boolean {
        return this.length === 0;
    }

    public isFull(): boolean {
        return this.length === this.maxLength;
    }
}

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
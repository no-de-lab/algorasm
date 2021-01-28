```cpp
class MyCircularQueue {
private:
    int rear;
    int front;
    int size;
    int *arr;
public:
    MyCircularQueue(int k) {
        size = k;
        rear = -1;
        front = -1;
        arr = new int[k];
    }
    
    bool enQueue(int value) {
        if(isFull()) {
            return false;
        }
        else if (isEmpty()) {
            rear = 0;
            front = 0;
            arr[rear] = value;
            return true;
        }
        else {
			rear = (rear+1)%size; 
            arr[rear] = value;
            return true;
        }
    }
    
    bool deQueue() {
        int x = 0;
        if(isEmpty()) {
            return false;
        }
        else if(front == rear) {
            x = arr[front];
			arr[front] = 0;
			rear = -1;
			front = -1;
            return true;
        }
        else {
            x = arr[front];
			arr[front] = 0;
			front = (front+1)%size;
			return true;
        }
    }
    
    int Front() {
        if(isEmpty()) {
            return -1;
        }
        cout<<front<<endl;
        return arr[front];
    }
    
    int Rear() {
        if(isEmpty()) {
            return -1;
        }
        return arr[rear];
    }
    
    bool isEmpty() {
		if (front == -1 && rear == -1)
			return true;
		else
			return false;
    }
    
    bool isFull() {
		if ((rear+1)%size == front) {
			return true;
		}
		else {
			return false;
		}
    }
};


MyCircularQueue obj = new MyCircularQueue(k);
bool param_1 = obj->enQueue(value);
bool param_2 = obj->deQueue();
int param_3 = obj->Front();
int param_4 = obj->Rear();
bool param_5 = obj->isEmpty();
bool param_6 = obj->isFull();
```

public class Deque extends CircularQueue {
    Deque() {
        front = -1;
        rear = -1;
    }

    private void frontAdd(int val) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        } else if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = len -1;

        } else {
            front -= 1;
        }
        queue[front] = val;        
    }

    private void frontRemove() {
        dequeue();
    }

    private void rearAdd(int val) {
        enqueue(val);
    }

    private void rearRemove() {
        if (isEmpty()) {
            System.out.println("Queue is empty");       
        } else if (rear == 0) {
            rear = len - 1;
            
        } else {
            rear -= 1;
        }
    }
}

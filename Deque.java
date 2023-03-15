public class Deque extends CircularQueue {
    public Deque() {
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


    public static void main(String[] args) {
        Deque deque = new Deque();

        deque.getFront();
        deque.rearAdd(4);
        
        deque.rearAdd(56);
        
        deque.frontAdd(24);
        
        
        deque.frontAdd(90);
        deque.frontAdd(12);
        
        
        deque.frontRemove();
        deque.frontRemove();
        deque.frontRemove();
        deque.rearRemove();
        deque.frontRemove();
        
        deque.getFront();
        deque.getRear();

        deque.rearAdd(4);
        deque.rearAdd(56);
        deque.rearAdd(78);
        deque.rearAdd(34);
        deque.rearAdd(90);
        deque.frontAdd(345);



        
    }




}

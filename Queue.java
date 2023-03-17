public class Queue {
    final protected int len = 5;
    protected int[] queue = new int[len];
    protected int front, rear;
    
    Queue() {
        front = -1;
        rear = -1;
    }
    

    protected void enqueue(int val) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        } else if (isEmpty()) {
            front += 1;
            rear += 1;
            
        } else {
            rear += 1;
            
        }
        queue[rear] = val;
    } 

    protected void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty;");
        } else {
            front += 1;
        }
    }

    protected void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println(queue[front]);
        }
    }

    protected boolean isFull() {
        if (rear == len-1) {
            return true;
        }
        return false;
    }

    protected boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }
}



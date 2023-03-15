public class CircularQueue extends Queue {

    public CircularQueue() {
        front = -1;
        rear = -1;
    }

    protected void enqueue(int val) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        } else if (isEmpty()) {
            front+=1;
            rear+=1;

        } else {
            rear = (rear+1) % len;
        }

        queue[rear] = val;
        
    }

    protected void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front+1) % len;
        }
    }

    protected void getFront() {
        peek();
    }

    protected void getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println(queue[rear]);
        }
    }

    protected boolean isFull() {
        if (front == (rear+1) % len) {
            return true;
        }
        return false;

    }

    

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();

        queue.getFront();
        queue.getRear();

        queue.enqueue(45);
        queue.enqueue(43);
        queue.enqueue(21);
        queue.enqueue(67);
        queue.enqueue(34);
        queue.enqueue(12);

        queue.getFront();
        queue.getRear();

        queue.dequeue();

        queue.getFront();
        queue.getRear();
        queue.dequeue();

        queue.getFront();

        queue.enqueue(99);
        queue.getRear();

        queue.enqueue(56);
        queue.getRear();

        queue.enqueue(1000);

    }

}

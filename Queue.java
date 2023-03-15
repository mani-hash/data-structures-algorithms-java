import java.util.Scanner;

public class Queue {
    final protected int len = 5;
    protected int[] queue = new int[len];
    protected int front, rear;
    
    public Queue() {
        front = -1;
        rear = -1;
    }

    private void enqueue(int val) {
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

    private void dequeue() {
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

    private boolean isFull() {
        if (rear == len-1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }

    
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.peek();

        queue.enqueue(45);
        queue.peek();
        Scanner inp = new Scanner(System.in);
        while (!(queue.isFull())) {

            queue.enqueue(inp.nextInt());
        }

        inp.close();

        queue.enqueue(100);

        queue.peek();

        while (!(queue.isEmpty())) {
            queue.dequeue();
        }

        queue.dequeue();


    }






}


public class Stack {
    final private int len = 5; 
    private int[] stack = new int[len];
    private int stack_pointer;
    
    Stack() {
        stack_pointer = -1;
    }

    private void push(int val) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            stack_pointer+=1;
            stack[stack_pointer] = val;

        }

    }

    private void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            stack_pointer -= 1;
        }
    }

    private void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            
        } else {
            System.out.println(stack[stack_pointer]);
        }
    }

    private boolean isFull() {
        if (stack_pointer == len - 1) {
            return true;
        }
        return false;
    }

    private boolean isEmpty() {
        if (stack_pointer == -1) {
            return true;
        }
        return false;
    }


}

public class Stack {
    final private int len = 5; 
    private int[] stack = new int[len];
    private int stack_pointer;
    
    public Stack() {
        stack_pointer = -1;
    }
    public void push(int val) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            stack_pointer+=1;
            stack[stack_pointer] = val;

        }

    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            stack_pointer -= 1;
        }
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            
        } else {
            System.out.println(stack[stack_pointer]);
        }
    }

    public boolean isFull() {
        if (stack_pointer == len - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (stack_pointer == -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.peek();
        stack.push(5);
        stack.peek();
        stack.push(6);
        stack.push(89);
        stack.push(56);
        stack.push(12);
        stack.push(45);
        
        stack.pop();
        stack.peek();

        while (!(stack.isEmpty())) {
            stack.pop();
        }

        stack.pop();
        stack.peek();
    }

}

public class PostfixStack {

    private double[] stack;
    private int top;

    public PostfixStack(int size) {

        stack = new double[size];

        top = -1;
    }


    // Add value to top of stack
    public void push(double value) {

        if (top == stack.length - 1) {

            System.out.println("Stack is full.");
            return;
        }

        top++;

        stack[top] = value;
    }


    // Remove value from top
    public double pop() {

        if (isEmpty()) {

            System.out.println("Stack is empty.");
            return 0;
        }

        double value = stack[top];

        top--;

        return value;
    }


    // Look at top value without removing it
    public double peek() {

        if (isEmpty()) {

            System.out.println("Stack is empty.");
            return 0;
        }

        return stack[top];
    }


    public boolean isEmpty() {

        return top == -1;
    }


    // Used to show the stack during evaluation
    public void displayStack() {

        System.out.print("Stack: [ ");

        for (int i = 0; i <= top; i++) {

            System.out.print(stack[i] + " ");
        }

        System.out.println("]");
    }
}
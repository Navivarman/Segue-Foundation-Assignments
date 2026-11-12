class CustomStack {
    int[] stack;
    int top;
    int capacity;

    CustomStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    // Insert patient
    void push(int patientId) {

        if (top == capacity - 1) {
            System.out.println("Stack is full!");
            return;
        }
        stack[++top] = patientId;
        System.out.println("Patient viewed: " + patientId);
    }

    // Remove recently viewed patient
    int pop() {

        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stack[top--];
    }

    // View top element
    int peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stack[top];
    }

    // Display stack
    void display() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {

        CustomStack s = new CustomStack(5);

        s.push(101);
        s.push(102);
        s.push(103);

        s.display();
        System.out.println("Removed: " + s.pop());
        System.out.println("Top: " + s.peek());
        s.display();
    }
}

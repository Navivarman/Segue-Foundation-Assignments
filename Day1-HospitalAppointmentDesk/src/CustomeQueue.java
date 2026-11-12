
class CustomQueue {
    int[] queue;
    int front;
    int rear;
    int size;
    int capacity;

    CustomQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Insert patient
    void enqueue(int patientId) {
        if (size == capacity) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = patientId;
        size++;

        System.out.println("Patient added: " + patientId);
    }

    // Remove patient
    int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }

        int removed = queue[front];
        front = (front + 1) % capacity;
        size--;
        if (size == 0) {
            front = 0;
            rear = -1;
        }
        return removed;
    }

    // View first patient
    int peek() {

        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queue[front];
    }

    // Display patients
    void display() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return;
        }
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        CustomQueue q = new CustomQueue(5);

        q.enqueue(101);
        q.enqueue(102);
        q.enqueue(103);

        q.display();

        System.out.println("Removed: " + q.dequeue());

        System.out.println("Front: " + q.peek());

        q.display();
    }
}


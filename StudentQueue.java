public class StudentQueue {

    private Student[] queue;
    private int front;
    private int rear;
    private int size;

    public StudentQueue(int size) {
        this.size = size;
        queue = new Student[size];

        front = -1;
        rear = -1;
    }

    // Add a student to the rear of the queue
    public void enqueue(Student student) {

        if (rear == size - 1) {
            System.out.println("Queue is full.");
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear++;
        }

        queue[rear] = student;

        System.out.println(student.name + " joined the waiting queue.");
    }

    // Remove and return the student at the front
    public Student dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }

        Student studentServed = queue[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }

        return studentServed;
    }

    // View the student at the front without removing them
    public Student peek() {

        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }

        return queue[front];
    }

    // Check whether the queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Display all waiting students
    public void displayQueue() {

        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("\n--- WAITING STUDENTS ---");

        for (int i = front; i <= rear; i++) {
            queue[i].displayStudent();
        }
    }
}
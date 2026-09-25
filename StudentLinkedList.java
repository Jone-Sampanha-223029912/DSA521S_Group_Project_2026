public class StudentLinkedList {

    // Node used inside the linked list
    private class Node {

        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Used by the integrated service-centre menu
    public void insertStudent(Student student) {

    insertAtEnd(student);
}


    // Insert at the beginning
    public void insertAtBeginning(Student student) {

        Node newNode = new Node(student);

        newNode.next = head;
        head = newNode;

        System.out.println(
                student.name + " inserted at the beginning."
        );
    }


    // Insert at the end
    public void insertAtEnd(Student student) {

        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        System.out.println(
                student.name + " inserted at the end."
        );
    }


    // Insert at a specified position
    // Position starts from 1
    public void insertAtPosition(Student student, int position) {

        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            insertAtBeginning(student);
            return;
        }

        Node newNode = new Node(student);

        Node current = head;

        int currentPosition = 1;

        while (current != null &&
               currentPosition < position - 1) {

            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Position does not exist.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;

        System.out.println(
                student.name +
                " inserted at position " +
                position + "."
        );
    }


    // Search for a student using student number
    public Student searchStudent(String studentNumber) {

        Node current = head;

        while (current != null) {

            if (current.data.studentNumber.equals(studentNumber)) {
                return current.data;
            }

            current = current.next;
        }

        return null;
    }


    // Delete a student using student number
    public boolean deleteStudent(String studentNumber) {

        if (head == null) {
            return false;
        }

        // Student is at the beginning
        if (head.data.studentNumber.equals(studentNumber)) {

            System.out.println(
                    "Deleted: " + head.data.name
            );

            head = head.next;

            return true;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.data.studentNumber.equals(studentNumber)) {

                System.out.println(
                        "Deleted: " + current.next.data.name
                );

                current.next = current.next.next;

                return true;
            }

            current = current.next;
        }

        return false;
    }


    // Traverse and display the whole linked list
    public void displayStudents() {

        if (head == null) {
            System.out.println("Student record list is empty.");
            return;
        }

        System.out.println("\n--- STUDENT SERVICE RECORDS ---");

        Node current = head;

        while (current != null) {

            current.data.displayStudent();

            current = current.next;
        }
    }
}
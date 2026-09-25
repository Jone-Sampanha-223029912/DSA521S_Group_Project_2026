public class Student {

    String studentNumber;
    String name;
    String serviceType;
    int estimatedServiceTime;

    public Student(String studentNumber, String name,
                   String serviceType, int estimatedServiceTime) {

        this.studentNumber = studentNumber;
        this.name = name;
        this.serviceType = serviceType;
        this.estimatedServiceTime = estimatedServiceTime;
    }

    public void displayStudent() {
        System.out.println(
            studentNumber + " | "
            + name + " | "
            + serviceType + " | "
            + estimatedServiceTime + " min"
        );
    }
}
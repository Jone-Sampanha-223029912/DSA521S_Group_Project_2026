import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentQueue waitingQueue =
                new StudentQueue(100);

        StudentLinkedList records =
                new StudentLinkedList();

        DailyStatistics statistics =
                new DailyStatistics(100);

        int choice = 0;


        while (choice != 11) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("       CAMPUS SERVICE CENTRE");
            System.out.println("========================================");
            System.out.println("1. Add student to waiting queue");
            System.out.println("2. Serve next student");
            System.out.println("3. Display waiting students");
            System.out.println("4. Add student service record");
            System.out.println("5. Display student service records");
            System.out.println("6. Search for student record");
            System.out.println("7. Remove student record");
            System.out.println("8. Display daily statistics");
            System.out.println("9. Sort service times");
            System.out.println("10. Run sorting experiment");
            System.out.println("11. Exit");
            System.out.print("Select option: ");


            try {

                choice =
                        Integer.parseInt(
                                scanner.nextLine()
                        );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );

                continue;
            }


            switch (choice) {

                case 1:

                    addStudentToQueue(
                            scanner,
                            waitingQueue
                    );

                    break;


                case 2:

                    serveStudent(
                            waitingQueue,
                            statistics
                    );

                    break;


                case 3:

                    waitingQueue.displayQueue();

                    break;


                case 4:

                    addStudentRecord(
                            scanner,
                            records
                    );

                    break;


                case 5:

                    records.displayStudents();

                    break;


                case 6:

                    searchStudentRecord(
                            scanner,
                            records
                    );

                    break;


                case 7:

                    removeStudentRecord(
                            scanner,
                            records
                    );

                    break;


                case 8:

                    System.out.println(
                            "\n--- DAILY STATISTICS ---"
                    );

                    statistics.displayStatistics();

                    break;


                case 9:

                    sortServiceTimes(
                            scanner,
                            statistics
                    );

                    break;


                case 10:

                    System.out.println(
                            "\n--- SORTING EXPERIMENT ---"
                    );

                    SortingExperiment experiment =
                            new SortingExperiment();

                    experiment.runExperiment();

                    break;


                case 11:

                    System.out.println(
                            "Exiting Campus Service Centre."
                    );

                    break;


                default:

                    System.out.println(
                            "Invalid option. Choose 1 to 11."
                    );
            }
        }


        scanner.close();
    }


    // ==================================================
    // OPTION 1
    // ==================================================

    private static void addStudentToQueue(
            Scanner scanner,
            StudentQueue waitingQueue) {

        System.out.println(
                "\n--- ADD STUDENT TO WAITING QUEUE ---"
        );


        System.out.print("Student Number: ");

        String studentNumber =
                scanner.nextLine();


        System.out.print("Student Name: ");

        String name =
                scanner.nextLine();


        System.out.print("Service Type: ");

        String serviceType =
                scanner.nextLine();


        System.out.print(
                "Estimated Service Time (minutes): "
        );


        int serviceTime;

        try {

                serviceTime =
                        Integer.parseInt(
                                scanner.nextLine()
                        );

        } catch (NumberFormatException e) {

                System.out.println(
                "Invalid service time."
                );

        return;
        }


        if (serviceTime <= 0) {

                System.out.println(
                "Service time must be greater than 0."
        );

        return;
        }


        Student student =
                new Student(
                        studentNumber,
                        name,
                        serviceType,
                        serviceTime
                );


        waitingQueue.enqueue(student);
        }


    // ==================================================
    // OPTION 2
    // ==================================================

    private static void serveStudent(
            StudentQueue waitingQueue,
            DailyStatistics statistics) {

        Student servedStudent =
                waitingQueue.dequeue();


        if (servedStudent != null) {

            System.out.println(
                    "\nStudent being served:"
            );

            servedStudent.displayStudent();


            // Store service time in daily array
            statistics.addServiceTime(
                    servedStudent.estimatedServiceTime
            );
        }
    }


    // ==================================================
    // OPTION 4
    // ==================================================

    private static void addStudentRecord(
        Scanner scanner,
        StudentLinkedList records) {

    System.out.println("\n--- ADD STUDENT SERVICE RECORD ---");

    System.out.print("Student Number: ");
    String studentNumber = scanner.nextLine().trim();

    System.out.print("Student Name: ");
    String name = scanner.nextLine().trim();

    System.out.print("Service Type: ");
    String serviceType = scanner.nextLine().trim();

    System.out.print("Estimated Service Time (minutes): ");
    String serviceTimeInput = scanner.nextLine().trim();

    int serviceTime;

    try {
        serviceTime = Integer.parseInt(serviceTimeInput);
    } catch (NumberFormatException e) {
        System.out.println("Invalid service time.");
        return;
    }

    if (serviceTime <= 0) {
        System.out.println("Service time must be greater than 0.");
        return;
    }

    Student student = new Student(
            studentNumber,
            name,
            serviceType,
            serviceTime
    );

    records.insertStudent(student);

    System.out.println("Student service record added successfully.");
}


    // ==================================================
    // OPTION 6
    // ==================================================

    private static void searchStudentRecord(
            Scanner scanner,
            StudentLinkedList records) {

        System.out.println(
                "\n--- SEARCH STUDENT RECORD ---"
        );


        System.out.print(
                "Enter Student Number: "
        );


        String studentNumber =
                scanner.nextLine();


        Student found =
                records.searchStudent(
                        studentNumber
                );


        if (found != null) {

            System.out.println(
                    "Student found:"
            );

            found.displayStudent();

        } else {

            System.out.println(
                    "Student record not found."
            );
        }
    }


    // ==================================================
    // OPTION 7
    // ==================================================

    private static void removeStudentRecord(
            Scanner scanner,
            StudentLinkedList records) {

        System.out.println(
                "\n--- REMOVE STUDENT RECORD ---"
        );


        System.out.print(
                "Enter Student Number: "
        );


        String studentNumber =
                scanner.nextLine();


        boolean deleted =
                records.deleteStudent(
                        studentNumber
                );


        if (!deleted) {

            System.out.println(
                    "Student record not found."
            );
        }
    }


    // ==================================================
    // OPTION 9
    // ==================================================

    private static void sortServiceTimes(
            Scanner scanner,
            DailyStatistics statistics) {

        if (statistics.getCount() == 0) {

            System.out.println(
                    "No service times available to sort."
            );

            return;
        }


        int[] serviceTimes =
                statistics.getServiceTimesCopy();


        System.out.println(
                "\n--- SORT SERVICE TIMES ---"
        );

        System.out.println(
                "1. Selection Sort"
        );

        System.out.println(
                "2. Insertion Sort"
        );

        System.out.println(
                "3. Merge Sort"
        );

        System.out.println(
                "4. Quick Sort"
        );

        System.out.print(
                "Choose sorting algorithm: "
        );


        int sortChoice;

        try {

            sortChoice =
                    Integer.parseInt(
                            scanner.nextLine()
                    );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid choice."
            );

            return;
        }


        switch (sortChoice) {

            case 1:

                SelectionSort selection =
                        new SelectionSort();

                selection.sortForExperiment(
                        serviceTimes
                );

                break;


            case 2:

                InsertionSort insertion =
                        new InsertionSort();

                insertion.sortForExperiment(
                        serviceTimes
                );

                break;


            case 3:

                MergeSort merge =
                        new MergeSort();

                merge.sort(
                        serviceTimes
                );

                break;


            case 4:

                QuickSort quick =
                        new QuickSort();

                quick.sort(
                        serviceTimes
                );

                break;


            default:

                System.out.println(
                        "Invalid sorting option."
                );

                return;
        }


        System.out.print(
                "Sorted Service Times: [ "
        );


        for (int i = 0;
             i < serviceTimes.length;
             i++) {

            System.out.print(
                    serviceTimes[i]
            );


            if (i <
                serviceTimes.length - 1) {

                System.out.print(", ");
            }
        }


        System.out.println(" ]");
    }
}
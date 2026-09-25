public class DailyStatistics {

    private int[] serviceTimes;
    private int count;


    public DailyStatistics(int size) {

        serviceTimes = new int[size];

        count = 0;
    }


    // Add a service time to the array
    public void addServiceTime(int time) {

        if (count == serviceTimes.length) {

            System.out.println(
                    "Service-time array is full."
            );

            return;
        }

        serviceTimes[count] = time;

        count++;
    }


    public void displayStatistics() {

        if (count == 0) {

            System.out.println(
                    "No students have been served."
            );

            return;
        }


        int totalTime = 0;

        int highestTime = serviceTimes[0];

        int lowestTime = serviceTimes[0];

        int longerThanTen = 0;


        // Traverse the array manually
        for (int i = 0; i < count; i++) {

            totalTime =
                    totalTime + serviceTimes[i];


            if (serviceTimes[i] > highestTime) {

                highestTime = serviceTimes[i];
            }


            if (serviceTimes[i] < lowestTime) {

                lowestTime = serviceTimes[i];
            }


            if (serviceTimes[i] > 10) {

                longerThanTen++;
            }
        }


        double average =
                (double) totalTime / count;


        System.out.println(
                "Total students served: " + count
        );

        System.out.println(
                "Total service time: "
                + totalTime + " minutes"
        );

        System.out.println(
                "Average service time: "
                + average + " minutes"
        );

        System.out.println(
                "Highest service time: "
                + highestTime + " minutes"
        );

        System.out.println(
                "Lowest service time: "
                + lowestTime + " minutes"
        );

        System.out.println(
                "Services longer than 10 minutes: "
                + longerThanTen
        );
    }

    public int getCount() {

    return count;
    }


    public int[] getServiceTimesCopy() {

        int[] copy = new int[count];

        for (int i = 0; i < count; i++) {

            copy[i] = serviceTimes[i];
        }

        return copy;
    }
}
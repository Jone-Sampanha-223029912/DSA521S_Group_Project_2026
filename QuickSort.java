public class QuickSort {

    private long comparisons;
    private boolean showTrace;
    private int partitionStage;


    public QuickSort() {

        comparisons = 0;
        showTrace = false;
        partitionStage = 0;
    }


    // Normal version for the experiment later
    public void sort(int[] array) {

        comparisons = 0;
        showTrace = false;
        partitionStage = 0;

        quickSort(array, 0, array.length - 1);
    }


    // Version used for Part B4
    public void sortWithTrace(int[] array) {

        comparisons = 0;
        showTrace = true;
        partitionStage = 0;

        System.out.println(
                "Pivot rule: First element of each partition"
        );

        System.out.print("Original Array: ");
        displayArray(array);

        quickSort(array, 0, array.length - 1);
    }


    private void quickSort(
            int[] array,
            int start,
            int end) {

        if (start < end) {

            int pivotPosition =
                    partition(array, start, end);


            quickSort(
                    array,
                    start,
                    pivotPosition - 1
            );


            quickSort(
                    array,
                    pivotPosition + 1,
                    end
            );
        }
    }


    private int partition(
            int[] array,
            int start,
            int end) {

        int pivotValue = array[start];

        int i = start + 1;
        int j = end;


        while (true) {

            // Move i from left to right
            while (i <= end) {

                comparisons++;

                if (array[i] <= pivotValue) {

                    i++;

                } else {

                    break;
                }
            }


            // Move j from right to left
            while (j > start) {

                comparisons++;

                if (array[j] > pivotValue) {

                    j--;

                } else {

                    break;
                }
            }


            if (i < j) {

                int temp = array[i];

                array[i] = array[j];

                array[j] = temp;

            } else {

                break;
            }
        }


        // Put pivot in its correct position
        int temp = array[start];

        array[start] = array[j];

        array[j] = temp;


        partitionStage++;


        // Project requires at least first two stages
        if (showTrace && partitionStage <= 2) {

            System.out.println(
                    "\nPartition Stage "
                    + partitionStage
            );

            System.out.println(
                    "Pivot: " + pivotValue
            );


            System.out.print("Left Partition: ");

            displayRange(
                    array,
                    start,
                    j - 1
            );


            System.out.print("Right Partition: ");

            displayRange(
                    array,
                    j + 1,
                    end
            );
        }


        return j;
    }


    public long getComparisons() {

        return comparisons;
    }


    public void displayArray(int[] array) {

        System.out.print("[ ");

        for (int i = 0;
             i < array.length;
             i++) {

            System.out.print(array[i]);

            if (i < array.length - 1) {

                System.out.print(", ");
            }
        }

        System.out.println(" ]");
    }


    private void displayRange(
            int[] array,
            int start,
            int end) {

        System.out.print("[ ");

        if (start <= end) {

            for (int i = start;
                 i <= end;
                 i++) {

                System.out.print(array[i]);

                if (i < end) {

                    System.out.print(", ");
                }
            }
        }

        System.out.println(" ]");
    }
}
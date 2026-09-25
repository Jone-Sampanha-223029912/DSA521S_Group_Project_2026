public class MergeSort {

    private int comparisons;
    private boolean showTrace;


    public MergeSort() {

        comparisons = 0;
        showTrace = false;
    }


    // Normal version
    // We will use this later in the sorting experiment
    public void sort(int[] array) {

        comparisons = 0;
        showTrace = false;

        mergeSort(array, 0, array.length - 1);
    }


    // Version that shows the divide-and-merge process
    public void sortWithTrace(int[] array) {

        comparisons = 0;
        showTrace = true;

        System.out.print("Original Array: ");
        displayArray(array);

        mergeSort(array, 0, array.length - 1);
    }


    private void mergeSort(
            int[] array,
            int low,
            int high) {

        // BASE CASE
        if (low >= high) {

            if (showTrace) {

                System.out.print("Base case: ");

                displayRange(array, low, high);
            }

            return;
        }


        int middle =
                (low + high) / 2;


        if (showTrace) {

            System.out.print("\nDivide: ");

            displayRange(array, low, high);

            System.out.print("Left:   ");

            displayRange(array, low, middle);

            System.out.print("Right:  ");

            displayRange(array, middle + 1, high);
        }


        // Divide left side
        mergeSort(
                array,
                low,
                middle
        );


        // Divide right side
        mergeSort(
                array,
                middle + 1,
                high
        );


        // Merge both sides
        merge(
                array,
                low,
                middle,
                high
        );


        if (showTrace) {

            System.out.print("Merged: ");

            displayRange(array, low, high);
        }
    }


    private void merge(
            int[] array,
            int low,
            int middle,
            int high) {

        int leftSize =
                middle - low + 1;

        int rightSize =
                high - middle;


        int[] left =
                new int[leftSize];

        int[] right =
                new int[rightSize];


        // Copy left side
        for (int i = 0; i < leftSize; i++) {

            left[i] =
                    array[low + i];
        }


        // Copy right side
        for (int j = 0; j < rightSize; j++) {

            right[j] =
                    array[middle + 1 + j];
        }


        int i = 0;
        int j = 0;
        int k = low;


        // Compare values from both sides
        while (i < leftSize &&
               j < rightSize) {

            comparisons++;

            if (left[i] <= right[j]) {

                array[k] = left[i];

                i++;

            } else {

                array[k] = right[j];

                j++;
            }

            k++;
        }


        // Copy remaining left values
        while (i < leftSize) {

            array[k] = left[i];

            i++;
            k++;
        }


        // Copy remaining right values
        while (j < rightSize) {

            array[k] = right[j];

            j++;
            k++;
        }
    }


    public int getComparisons() {

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
            int low,
            int high) {

        System.out.print("[ ");

        for (int i = low;
             i <= high;
             i++) {

            System.out.print(array[i]);

            if (i < high) {

                System.out.print(", ");
            }
        }

        System.out.println(" ]");
    }
}
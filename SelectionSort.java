public class SelectionSort {

    private int comparisons;
    private int swaps;


    public SelectionSort() {

        comparisons = 0;
        swaps = 0;
    }


    public void sort(int[] array) {

    sortInternal(array, true);
}


public void sortForExperiment(int[] array) {

    sortInternal(array, false);
}


private void sortInternal(
        int[] array,
        boolean showPasses) {

    comparisons = 0;
    swaps = 0;

    int n = array.length;


    for (int i = 0; i < n - 1; i++) {

        int minIndex = i;


        for (int j = i + 1; j < n; j++) {

            comparisons++;

            if (array[j] < array[minIndex]) {

                minIndex = j;
            }
        }


        int temp = array[i];

        array[i] = array[minIndex];

        array[minIndex] = temp;

        swaps++;


        if (showPasses && i < 3) {

            System.out.print(
                    "After Pass " + (i + 1) + ": "
            );

            displayArray(array);
        }
    }
}


    public int getComparisons() {

        return comparisons;
    }


    public int getSwaps() {

        return swaps;
    }


    public void displayArray(int[] array) {

        System.out.print("[ ");

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i]);

            if (i < array.length - 1) {

                System.out.print(", ");
            }
        }

        System.out.println(" ]");
    }
}
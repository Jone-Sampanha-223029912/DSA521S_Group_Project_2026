public class InsertionSort {

    private int comparisons;
    private int shifts;


    public InsertionSort() {

        comparisons = 0;
        shifts = 0;
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
    shifts = 0;


    for (int i = 1; i < array.length; i++) {

        int key = array[i];

        int j = i - 1;


        while (j >= 0) {

            comparisons++;

            if (array[j] > key) {

                array[j + 1] = array[j];

                shifts++;

                j--;

            } else {

                break;
            }
        }


        array[j + 1] = key;


        if (showPasses && i <= 3) {

            System.out.print(
                    "After Pass " + i + ": "
            );

            displayArray(array);
        }
    }
}


    public int getComparisons() {

        return comparisons;
    }


    public int getShifts() {

        return shifts;
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
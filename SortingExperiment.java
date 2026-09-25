import java.util.Random;

public class SortingExperiment {

    private Random random;

    public SortingExperiment() {

        // Fixed seed makes the experiment reproducible
        random = new Random(2026);
    }


    // Generate one original array
    private int[] generateArray(int size) {

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {

            array[i] = random.nextInt(1000);
        }

        return array;
    }


    // Make our own copy of an array
    private int[] copyArray(int[] original) {

        int[] copy =
                new int[original.length];

        for (int i = 0;
             i < original.length;
             i++) {

            copy[i] = original[i];
        }

        return copy;
    }


    public void runExperiment() {

    int[] sizes =
            {20, 50, 100, 500};


    int[] original100 = null;


    System.out.println(
            "\nALGORITHM\tSIZE\tCOMPARISONS\tTIME(ns)"
    );

    System.out.println(
            "--------------------------------------------------"
    );


    for (int s = 0; s < sizes.length; s++) {

        int size = sizes[s];


        // Generate one original array
        int[] original =
                generateArray(size);


        // Save the original 100-element array
        if (size == 100) {

            original100 =
                    copyArray(original);
        }


        runSelectionSort(original, size);

        runInsertionSort(original, size);

        runMergeSort(original, size);

        runQuickSort(original, size);


        System.out.println(
                "--------------------------------------------------"
        );
    }


    // Run the additional almost-sorted test
    runAlmostSortedExperiment(original100);
}


    private void runSelectionSort(
            int[] original,
            int size) {

        int[] array =
                copyArray(original);

        SelectionSort selection =
                new SelectionSort();


        long start =
                System.nanoTime();


        // Only sorting happens between start and end
        selection.sortForExperiment(array);


        long end =
                System.nanoTime();


        long time =
                end - start;


        System.out.println(
                "Selection\t"
                + size + "\t"
                + selection.getComparisons()
                + "\t\t"
                + time
        );
    }


    private void runInsertionSort(
            int[] original,
            int size) {

        int[] array =
                copyArray(original);

        InsertionSort insertion =
                new InsertionSort();


        long start =
                System.nanoTime();


        insertion.sortForExperiment(array);


        long end =
                System.nanoTime();


        long time =
                end - start;


        System.out.println(
                "Insertion\t"
                + size + "\t"
                + insertion.getComparisons()
                + "\t\t"
                + time
        );
    }


    private void runMergeSort(
            int[] original,
            int size) {

        int[] array =
                copyArray(original);

        MergeSort merge =
                new MergeSort();


        long start =
                System.nanoTime();


        merge.sort(array);


        long end =
                System.nanoTime();


        long time =
                end - start;


        System.out.println(
                "Merge\t\t"
                + size + "\t"
                + merge.getComparisons()
                + "\t\t"
                + time
        );
    }


    private void runQuickSort(
            int[] original,
            int size) {

        int[] array =
                copyArray(original);

        QuickSort quick =
                new QuickSort();


        long start =
                System.nanoTime();


        quick.sort(array);


        long end =
                System.nanoTime();


        long time =
                end - start;


        System.out.println(
                "Quick\t\t"
                + size + "\t"
                + quick.getComparisons()
                + "\t\t"
                + time
        );
    }

    private void runAlmostSortedExperiment(
        int[] original100) {


    System.out.println(
            "\n=============================================="
    );

    System.out.println(
            " ALMOST-SORTED 100-ELEMENT EXPERIMENT"
    );

    System.out.println(
            "=============================================="
    );


    // Make a copy of the original 100-element array
    int[] almostSorted =
            copyArray(original100);


    // Sort it into ascending order first
    MergeSort merge =
            new MergeSort();

    merge.sort(almostSorted);


    // Swap five pairs of neighbouring values
    swap(almostSorted, 5, 6);

    swap(almostSorted, 20, 21);

    swap(almostSorted, 40, 41);

    swap(almostSorted, 60, 61);

    swap(almostSorted, 80, 81);


    System.out.println(
            "\nFive neighbouring pairs were swapped."
    );


    System.out.println(
            "\nALGORITHM\tSIZE\tCOMPARISONS\tTIME(ns)"
    );

    System.out.println(
            "--------------------------------------------------"
    );


    // Every algorithm receives the SAME almost-sorted array
    runSelectionSort(almostSorted, 100);

    runInsertionSort(almostSorted, 100);

    runMergeSort(almostSorted, 100);

    runQuickSort(almostSorted, 100);


    System.out.println(
            "--------------------------------------------------"
    );
    }

    private void swap(
        int[] array,
        int first,
        int second) {

    int temp = array[first];

    array[first] = array[second];

    array[second] = temp;
    }
}
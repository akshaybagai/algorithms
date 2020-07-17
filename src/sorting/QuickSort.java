package sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] ints = {7,6,3,5,1,2,4};
        quickSort(ints, 0, ints.length-1);
    }

    private static void quickSort(int[] ints, int start, int end) {
        if(start < end) {
            int pivotIndex = partition(ints, start, end);

            quickSort(ints, start, pivotIndex - 1);
            quickSort(ints, pivotIndex + 1, end);

            System.out.println(Arrays.toString(ints));
        }
    }

    private static int partition(int[] ints, int start, int end) {
        int pivot = ints[end];
        int smaller = start-1;

        for (int bigger = start; bigger < end; bigger++) {
            if(ints[bigger] <= pivot) {
                smaller++;
                swap(ints, smaller, bigger);
            }
        }
        swap(ints,smaller+1, end);
        return smaller+1;
    }

    private static void swap(int[] ints, int first, int second) {
        int temp = ints[first];
        ints[first] = ints[second];
        ints[second] = temp;
    }

}

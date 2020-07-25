package problems;

import java.util.Arrays;

public class Inversions {

    private static int swaps = 0;
    public static void main(String[] args) {
        int[] ints = {5, 3, 45, 23, 20};
        mergeSort(ints, ints.length);
    }

    private static void mergeSort(int[] ints, int arrayLength) {
        if(arrayLength<2) {
            return;
        }
        int mid = arrayLength/2;
        int[] l = new int[mid];
        int[] r = new int[arrayLength-mid];

        //divide the array in two parts
        for (int i = 0; i < mid; i++) {
            l[i] = ints[i];
        }

        for (int i = mid; i < arrayLength; i++) {
            r[i-mid] = ints[i];
        }

        //sort the two halves separately
        mergeSort(l, mid);
        mergeSort(r, arrayLength-mid);

        System.out.println("L -> " +  Arrays.toString(l));
        System.out.println("R -> " +  Arrays.toString(r));

        merge(ints, l, r, mid, arrayLength-mid);
        System.out.println(Arrays.toString(ints));

        System.out.println("swaps -> " + swaps);
    }

    //merge the two halves by maintaining a pointer
    private static void merge(int[] ints, int[] l, int[] r, int left, int right) {
        int i=0,j=0,k=0;
        System.out.println("merge");
        while (i<left && j<right) {
            System.out.println(String.format("L %d R %d i %d j %d", left, right, i, j));
            if (l[i] > r[j] ) {
                swaps++;
            }
            i++;j++;
        }
    }
}

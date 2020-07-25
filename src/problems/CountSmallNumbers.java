package problems;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class CountSmallNumbers {

    static class Pair {
        int index;
        int val;

        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }

        public int getIndex() {
            return index;
        }

        public int getVal() {
            return val;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "index=" + index +
                    ", val=" + val +
                    '}';
        }
    }

    private static int[] outputArray;
    public static void main(String[] args) {
        int[] ints = {5,2,6,1,1};
        outputArray = new int[ints.length];
        Pair[] pairs = new Pair[ints.length];
        for (int i = 0; i < ints.length; i++) {
            pairs[i] = new Pair(i, ints[i]);
        }
        mergeSort(pairs, ints.length);
    }

    private static void mergeSort(Pair[] ints, int arrayLength) {
        if(arrayLength<2) {
            return;
        }
        int mid = arrayLength/2;
        Pair[] l = new Pair[mid];
        Pair[] r = new Pair[arrayLength-mid];

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

        merge(ints, l, r, mid, arrayLength-mid);
    }

    //merge the two halves by maintaining a pointer
    private static void merge(Pair[] ints, Pair[] left, Pair[] right, int leftIndex, int rightIndex) {
        System.out.println("------------------------");
        System.out.println("Before " + Arrays.toString(outputArray));

        for (int i = 0, j = 0; i < left.length || j < right.length;) {
            if (j == right.length ||
                    i < left.length && left[i].val <= right[j].val) {
                ints[i + j] = left[i];
                outputArray[left[i].index] += j;
                i++;
            } else {
                ints[i + j] = right[j];
                j++;
            }
        }

        System.out.println("After - " + Arrays.toString(outputArray));
    }
}

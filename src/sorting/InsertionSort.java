package sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] ints = {5, 3, 45, 23, 20};
        sortByBubblingUp(ints, ints.length);
        sortByShiftingElements(ints, ints.length);
        sortByIterativeApproach(ints);
    }

    private static void sortByBubblingUp(int[] ints, int n) {
        if (n<=1) return;
        sortByBubblingUp(ints, n-1);

        //to insert the nth element to its correct place
        //bubble up the element to its right position
        for (int j = n-1; j > 0; j--) {
            if(ints[j-1] > ints[j]) {
                int temp = ints[j-1];
                ints[j-1] = ints[j];
                ints[j] = temp;
            }
        }
        System.out.println(Arrays.toString(ints));
    }

    private static void sortByShiftingElements(int[] ints, int n) {
        if(n<=1) return;
        sortByShiftingElements(ints, n-1);

        //this is the element that we want to move to the right place
        int nth = ints[n-1];
        int j = n-1-1;//this is the previous element

        //compare the element to the left element
        //if the left element is bigger than the element move up the left element
        /*
        * 5, 3, 45, 23, 20
            * 5, 5, 45, 23, 20
            * 3, 5, 45, 23, 20
        * */
        while(j>0 && ints[j]>nth) {
            ints[j+1] = ints[j];
            j = j-1;
        }
        ints[j+1] = nth;
        System.out.println(Arrays.toString(ints));
    }

    private static void sortByIterativeApproach(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            int nth = ints[i];
            int j = i-1;

            while(j>0 && ints[j]>nth) {
                ints[j+1] = ints[j];
                j = j-1;
            }
            ints[j+1] = nth;
            System.out.println(Arrays.toString(ints));
        }
    }
}

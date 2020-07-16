package sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        bubbleSort(new int[]{20,3,5,7,11});
    }

    private static void bubbleSort(int[] ints) {

        for (int i = 0; i < ints.length; i++) {
            //in each iteration scan from right to left and
            // bubble up the smallest element to the leftmost position
            for (int j = ints.length-1; j > i; j--) {
                if(ints[j-1] > ints[j]) {
                    int temp = ints[j-1];
                    ints[j-1] = ints[j];
                    ints[j] = temp;
                }
            }
            System.out.println(Arrays.toString(ints));
        }
    }
}

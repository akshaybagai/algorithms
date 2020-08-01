package problems;

import java.util.Arrays;

public class Merge2SortedArrays {

    public static void main(String[] args) {
        int[] smaller = new int[] {1,2,3};
        int[] larger = new int[] {4,5,6,0,0,0};

        int sI  = smaller.length -1;
        int i  = larger.length - 1;
        int lIndex  = i/2;

        while (i >= 0) {
            if(lIndex >= 0 && larger[lIndex] > smaller[sI]) {
                larger[i--] = larger[lIndex--];
            }
            else {
                larger[i--] = smaller[sI--];
            }
            System.out.println(Arrays.toString(larger));
        }
    }
}

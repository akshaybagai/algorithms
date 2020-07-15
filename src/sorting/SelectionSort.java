package sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        selectionSort(new int[]{20,3,5,7,11});
    }

    public static void selectionSort(int[] array){
        int minimumIndex;
        int minValue;
        //loop through the array
        for (int i = 0; i < array.length; i++) {
            minimumIndex = i;
            minValue = array[i];
            //find the ith smallest element in the list
            for (int j = i+1; j <array.length; j++) {
                //at end of this loop, minimumIndex points to the min in the pending list
                if(array[j] < array[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            //swap the current element with the pending
            if(minimumIndex != i) {
                minValue = array[minimumIndex];
                array[minimumIndex] = array[i];
                array[i] = minValue;
            }
            System.out.println(Arrays.toString(array));
        }
    }
}

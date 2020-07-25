package sorting;

import java.util.Arrays;

public class MergeSortPractice {

    public static void main(String[] args) {
        int[] sortArray = new int[]{4,5,2,3,50,8,30,534,1};
        mergeSort(sortArray, sortArray.length);
        System.out.println(Arrays.toString(sortArray));
    }

    private static void mergeSort(int[] ints, int arrayLength) {

        if(arrayLength < 2) {return;}

        //divide and concur
        //split from between - divide array in half recursievely
        int size = arrayLength; //9
        int mid = size/2; //4

        int[] leftArray = new int[mid]; //4
        int[] rightArray = new int[size-mid]; //5

        //copy from 0 to length mid
        System.arraycopy(ints, 0,leftArray, 0, mid); //0 4
        //copy from mid element of
        System.arraycopy(ints, mid, rightArray, 0, size-mid); //length = 5 elements

        mergeSort(leftArray, mid);
        mergeSort(rightArray, size-mid);

        merge(ints, leftArray, rightArray);
    }

    private static void merge(int[] ints, int[] leftArray, int[] rightArray) {

        int leftLength = leftArray.length;
        int rightLength = rightArray.length;

        int leftPointer = 0;
        int rightPointer = 0;

        while(leftPointer < leftLength && rightPointer < rightLength) {
            if(leftArray[leftPointer] <= rightArray[rightPointer]) {
                ints[leftPointer+rightPointer] = leftArray[leftPointer++];
            }
            else {
                ints[leftPointer+rightPointer] = rightArray[rightPointer++];
            }
        }

        System.arraycopy(leftArray, leftPointer, ints, leftPointer+rightPointer, leftLength - leftPointer);
        System.arraycopy(rightArray, rightPointer, ints, leftPointer+rightPointer, rightLength - rightPointer);
    }


}

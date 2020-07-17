package sorting;

import java.util.Arrays;

public class MergeSort2 {

    private static int[] sortedArray;
    private static int sortedIndex = 0;

    public static void main(String[] args) {
        int[] ints = {5, 3, 45, 23, 20};
        sortedArray = new int[ints.length];
        mergeSort(ints, 0, ints.length);
    }

    private static void mergeSort(int[] ints, int startIndex, int endIndex) {
        if(startIndex>=endIndex) {
            return;
        }
        System.out.println("Start Index -> " +  startIndex);
        System.out.println("End Index -> " +  endIndex);

        int mid = (startIndex+endIndex)/2;

        mergeSort(ints, startIndex, mid);
        mergeSort(ints, mid+1, endIndex);

        merge(ints, startIndex,mid,endIndex);

    }

    private static void merge(int[] ints, int startIndex, int mid, int endIndex) {
        int i=0,j=mid;
        sortedArray = new int[endIndex - startIndex];
        sortedIndex = 0;

        while (i<startIndex && j<endIndex) {
            if(ints[i]<=ints[j]) {
                sortedArray[sortedIndex++] = ints[i++];
            }
            else {
                sortedArray[sortedIndex++] = ints[j++];
            }
        }

        while(i<mid) {
            sortedArray[sortedIndex++] = ints[i++];
        }
        while(j<endIndex) {
            sortedArray[sortedIndex++] = ints[j++];
        }

        int index=0;
        for (int k = startIndex; k < endIndex; k++) {
            ints[k]=sortedArray[index++];
        }
        System.out.println(Arrays.toString(ints));
    }
}

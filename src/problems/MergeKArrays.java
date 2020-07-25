package problems;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKArrays {

    /*
     * Complete the mergeArrays function below.
     */
    static int[] mergeArrays(int[][] arr) {

        class Element implements Comparable<Element> {

            public int arrayIndex;
            public int elementIndex;
            public int value;

            public Element(int arrayIndex, int elementIndex, int value) {
                this.arrayIndex = arrayIndex;
                this.elementIndex = elementIndex;
                this.value = value;
            }

            public int compareTo(Element e2) {
                return this.value - e2.value;
            }
        }

        int mergedArraySize = 0;
        PriorityQueue<Element> heapOfMins = new PriorityQueue<Element>();
        //add first element of all arrays into the priority queue
        for(int i =0; i<arr.length; i++) {
            heapOfMins.add(new Element(i, 0, arr[i][0]));
            mergedArraySize = mergedArraySize + arr[i].length;
        }

        int[] mergedArray = new int[mergedArraySize];
        int mergedIndex = 0;
        while(!heapOfMins.isEmpty()) {
            Element element = heapOfMins.poll();
            mergedArray[mergedIndex] = element.value;
            mergedIndex++;

            // if there is another element in the same array
            // add it to the priority queue
            int nextElementIndex = element.elementIndex +1;
            if( (nextElementIndex) < arr[element.arrayIndex].length ) {
                heapOfMins.add(new Element(element.arrayIndex, nextElementIndex , arr[element.arrayIndex][nextElementIndex]));
            }
        }

        return mergedArray;

    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrRows = Integer.parseInt(scan.nextLine().trim());
        int arrColumns = Integer.parseInt(scan.nextLine().trim());

        int[][] arr = new int[arrRows][arrColumns];

        for (int arrRowItr = 0; arrRowItr < arrRows; arrRowItr++) {
            String[] arrRowItems = scan.nextLine().split(" ");

            for (int arrColumnItr = 0; arrColumnItr < arrColumns; arrColumnItr++) {
                int arrItem = Integer.parseInt(arrRowItems[arrColumnItr].trim());
                arr[arrRowItr][arrColumnItr] = arrItem;
            }
        }

        int[] res = mergeArrays(arr);

        for (int resItr = 0; resItr < res.length; resItr++) {
            bw.write(String.valueOf(res[resItr]));

            if (resItr != res.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}

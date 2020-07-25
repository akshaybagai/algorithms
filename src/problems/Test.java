package problems;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        System.out.println(topK(new int[]{5,6,1}, 2));
    }

    static int[] topK(int[] arr, int k) {

        PriorityQueue<Integer> sorted = new PriorityQueue();
        Set<Integer> removeDuplicated = new HashSet();

        for(int i = 0; i<arr.length;i++) {
            if(sorted.isEmpty()) {
                System.out.println("adding " + arr[i]);
                sorted.add(arr[i]);
                removeDuplicated.add(arr[i]);
            }
            else {
                if(!removeDuplicated.contains(arr[i])) {
                    System.out.println("adding here" + arr[i]);
                    sorted.add(arr[i]);
                    removeDuplicated.add(arr[i]);

                    if(sorted.size() > k) {
                        System.out.println("removing here" + sorted.peek());
                        removeDuplicated.remove(sorted.poll());
                    }
                }else {
                    System.out.println("already exists " + arr[i]);
                }
            }
        }

        int[] sortedArray = new int[sorted.size()];
        System.out.println("sorted.size() " + sorted.size());
        for(int i=0; i<sortedArray.length;i++) {
            sortedArray[i] = sorted.poll();
        }

        return sortedArray;

    }
}

package problems;

import java.util.*;

public class IntersectArray {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(intersect(new int[] {3,4,5,6,7}, new int[] {7,8,9,10,11})));
    }

    private static Object[] intersect(int[] m, int[] n) {
        List<Integer> integerList = new ArrayList<>();
        int i =0 ,j = 0;

        int lastElement = -1;
        //use two pointers, one for m and one for n
        while(i < m.length && j < n.length) {
            if(m[i] == n[j]) {
                // to handle duplicates
                if (m[i] != lastElement) {
                    integerList.add(m[i]);
                    lastElement = m[i];
                }
                i++;j++;
            }
            else if(m[i] > n[j]) {
                j++;
            }else {
                i++;
            }
        }
        return integerList.toArray();
    }


}

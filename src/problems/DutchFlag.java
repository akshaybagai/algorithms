package problems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DutchFlag {
    //three way partition
    public static void main(String[] args) {
        int[] chars = {1,2,2,1,3,3,2};
        System.out.println(Arrays.toString(chars));

        int low = 0;
        int current = 0;
        int high = chars.length-1;

        while (current <= high) {
            if(chars[current] == 1) {
                swap(chars, current, low);
                low++;
                current++;
            }
            if(chars[current] == 2) {
                current++;
            }
            if(chars[current] == 3) {
                swap(chars, current, high);
                high--;
            }
            System.out.println(String.format("low %d current %d high %d", low, current, high));
            System.out.println(Arrays.toString(chars));
        }


    }

    private static void swap(int[] chars, int from, int to) {
        int temp = chars[from];
        chars[from] = chars[to];
        chars[to] = temp;
    }

}

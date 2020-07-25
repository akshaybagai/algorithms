package recursion;

import java.util.Arrays;

import static java.lang.String.format;

public class Fibonacci {

    public static void main(String[] args) {

        int[] arr = new int[10];
        fibonacciLeftToRight(arr);
        Arrays.stream(arr).forEach(x -> System.out.println(" " + x));

        long start = System. currentTimeMillis();
        System.out.println(format("nth term fibonacci %d time %d", fibonacci(45), System.currentTimeMillis() - start));

        start = System. currentTimeMillis();
        System.out.println(format("nth term additiveSequence %d time %d", additiveSequence(45, 0, 1), System.currentTimeMillis() - start));
    }

    //time complexity = O(1.4^n)
    private static int fibonacci(int i) {
        //base case
        if (i == 0 || i == 1 ) return i;
        else {
            return fibonacci(i-1) + fibonacci(i-2);
        }
    }

    //time complexity = O(n)
    private static void fibonacciLeftToRight(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(i == 0 || i == 1) {
                arr[i] = i;
            }
            else {
                arr[i] = arr[i-1] + arr[i-2];
            }
        }
    }

    //time complexity = O(n) as the number of child nodes is linear
    private static int additiveSequence(int nthTerm, int b1, int b2) {
        if (nthTerm == 0) {
            return b1;
        }
        else {
            return additiveSequence(nthTerm-1, b2, b1+b2);
        }
    }
}

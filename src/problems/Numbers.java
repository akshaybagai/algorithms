package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Character.getNumericValue;

public class Numbers {

    public static void main(String[] args) {

        addOperator("123", 6).forEach(System.out::println);
//        Arrays.stream(generate_all_expressions("123", 6)).forEach(System.out::println);
    }

    static String[] generate_all_expressions(String s, long target) {

        List<String> result = new ArrayList<>();

        char[] numbers = s.toCharArray();
        int numbersLength = numbers.length;
        int numberPointer = 0;

        char[] slate = new char[numbersLength + numbersLength];
        int slatePointer = 0;

        long value = 0;

        while(numberPointer<numbersLength) {
            value = (value * 10) + numbers[numberPointer]  -'0';
            slate[slatePointer++] = numbers[numberPointer];
            helper(numbers, numberPointer+1, slate, slatePointer,
                    0, value, result, target);

            numberPointer++;
        }
        return result.toArray(new String[0]);
    }

    private static void helper(char[] numbers, int numberPointer,
                               char[] slate, int slatePointer,
                               long previous, long tail, List<String> results, long target) {
        if(numberPointer == numbers.length) {
                System.out.println("Previous " + previous + " Tail " + tail);

            if(previous + tail == target) {
                results.add(new String(slate, 0, slatePointer));
//                System.out.println(new String(slate, 0, slatePointer));
            }
        }
        else {

            long currentNumber = 0;
            int operationPointer = slatePointer++;

            while(numberPointer<numbers.length) {
                currentNumber = (currentNumber * 10) + numbers[numberPointer]  -'0';
                slate[slatePointer++] = numbers[numberPointer];

//                slate[operationPointer] = '+';
//                helper(numbers, numberPointer + 1, slate, slatePointer, (previous + tail) , currentNumber, results, target);

                slate[operationPointer] = '*';
//                System.out.println("Previous " + previous + " Tail " + (currentNumber * tail));
//                System.out.println("Previous + Tail " + (previous + (currentNumber * tail)));
                helper(numbers, numberPointer + 1, slate, slatePointer, (previous) , (currentNumber * tail), results, target);

                numberPointer++;
            }

        }

    }

    private static List<String> addOperator(String string, int target) {
        List<String> res = new ArrayList<>();
        char[] nums = string.toCharArray();
        int n = nums.length;
        char[] slate = new char[n+n];

        int numberPointer = 0;
        int slatePointer = 0;

        long value = 0;
        while (numberPointer < nums.length) {
            value = value*10 + Character.getNumericValue(nums[numberPointer]);
            slate[slatePointer++] = nums[numberPointer];
            helper(nums, numberPointer + 1, slate, slatePointer, 0, value, target, res);
            numberPointer++;
            if (value ==0) break;
        }
        return res;
    }

    private static void helper(char[] nums, int numberPointer, char[] slate, int slatePointer,
                               long result, long tail, long target, List<String> res) {
        if(numberPointer == nums.length) {
            if(result+tail == target) {
                res.add(String.valueOf(slate, 0, slatePointer));
            }
        }
        else {
            long currentNumber = 0;
            int operationPointer = slatePointer++;
            while (numberPointer < nums.length) {
                currentNumber = currentNumber*10 + Character.getNumericValue(nums[numberPointer]);
                slate[slatePointer++] = nums[numberPointer];

                slate[operationPointer] = '+';
                helper(nums, numberPointer + 1, slate, slatePointer, result + tail, currentNumber, target, res);

                slate[operationPointer] = '*';
                helper(nums, numberPointer + 1, slate, slatePointer, result, tail * currentNumber, target, res);

                numberPointer++;
                if(currentNumber == 0) return;

            }
        }

    }
}

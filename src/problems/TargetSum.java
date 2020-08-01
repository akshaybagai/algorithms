package problems;

import java.util.ArrayList;
import java.util.List;

public class TargetSum {

    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>();
        System.out.println(check_if_sum_possible_reverse(new long[] {-1l, -2l, 3l}, 5, result));

    }

    private static boolean check_if_sum_possible_reverse(long[] arr, int target, List<String> strings) {
        recurseReverse(arr, 0, target, 0, strings);
        return !strings.isEmpty();
    }

    /**
     * Technique - instead of suming to target, approach it as distance from target. So everytime you add
     * a new number from the set, reduce the distance from the target.
     *
     * Count is required to make sure that empty set is not considered in sum
     */
    private static void recurseReverse(long[] arr, int index, long target, int count, List<String> strings) {
        if (target == 0 && count > 0) {
            strings.add("yes");
        }
        else if (index == arr.length) {
            return;
        }
        else {
            recurseReverse(arr, index + 1, target - arr[index], count+1, strings);
            recurseReverse(arr, index + 1, target, count, strings);
        }
    }

    static boolean check_if_sum_possible(long[] arr, long k) {
        List<String> results = new ArrayList();
        recurse(arr, 0, new ArrayList<Long>(), 0, results, 0, k);
        return !results.isEmpty();
    }

    private static void recurse(long[] arr, int index, List<Long> slate, int slateIndex, List<String> results, long sumSoFar, long k) {
        if (index == arr.length) {
            if (sumSoFar == k && !slate.isEmpty()) {
                results.add(slate.toString());
            }
        } else {
            slate.add(arr[index]);
            recurse(arr, index + 1, slate, slateIndex + 1, results, sumSoFar + arr[index], k);
            slate.remove(slate.size() - 1);

            recurse(arr, index + 1, slate, slateIndex + 1, results, sumSoFar, k);
        }
    }

}
package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;

public class SubSets {

    public static void main(String[] args) {
        List<List<Integer>> results = new ArrayList<>();

//        subset(new ArrayList<Integer>(), Arrays.asList(1,2,3), results, 0);
//        results.forEach(System.out:: println);

        List<List<String>> results2 = new ArrayList<>();
        permutations(new ArrayList<String>(), Arrays.asList("A","B", "C"), results2, 0 );
        results2.forEach(System.out:: println);

//        List<String> results1 = new ArrayList<>();
//        permutationsString("", Arrays.asList("1","2","3"), results1, 0);
//        results1.forEach(System.out:: println);

//        List<List<Integer>> results3 = new ArrayList<>();
//        subsetSum(new ArrayList<Integer>(), Arrays.asList(10, 3, 4, 7), results3, 0, 7);
//        results3.forEach(System.out:: println);

    }

    private static <T> void permutations(ArrayList<T> slate, List<T> availableWords, List<List<T>> results, int permutationLevel) {
        if(availableWords.isEmpty()) {
            results.add(new ArrayList<>(slate));
        }
        else {
            for(T e : availableWords) {
                List<T> updatedBagOfWords = new ArrayList<>(availableWords);
                updatedBagOfWords.remove(e);

                slate.add(e);
                permutations(slate, updatedBagOfWords, results, permutationLevel++);
                slate.remove(e);
            }
        }
    }

    private static void permutationsString(String slate, List<String> bagOfWords, List<String> results, int index) {
        if(bagOfWords.size() == 0) {
            results.add(slate);
        }
        else {
            for(String e : bagOfWords) {
                List<String> list = new ArrayList<>(bagOfWords);
                list.remove(e);
                permutationsString(slate + e, list, results, index + 1);
            }
        }
    }

    //this is more elegant than removing the words from the list
    //just maintain the index where you are operating at
    private static <T> void subset(List<T> slate, List<T> bagOfWords, List<List<T>> results, int index) {
        if (bagOfWords.size() == index) {
            results.add(new ArrayList<>(slate));
        }
        else {
            slate.add(bagOfWords.get(index));
            subset(slate, bagOfWords, results, index + 1);

            //this needs to happen after the slate.add because this is global state
            //if you modify the global state and do not remove the element then
            // you leave a corrupt state which can lead to errors
            slate.remove(slate.size() - 1);
            subset(slate, bagOfWords, results, index + 1);
        }
    }

    private static void subsetSum(List<Integer> slate, List<Integer> bagOfWords, List<List<Integer>> results, int index, Integer target) {
        if (bagOfWords.size() == index) {
            Integer reduce = slate.stream().reduce(0, Integer::sum);
            if(reduce.equals(target)) {
                results.add(new ArrayList<>(slate));
            }
        }
        else {
            slate.add(bagOfWords.get(index));
            subsetSum(slate, bagOfWords, results, index + 1, target);

            slate.remove(slate.size() - 1);
            subsetSum(slate, bagOfWords, results, index + 1, target);
        }
    }
}

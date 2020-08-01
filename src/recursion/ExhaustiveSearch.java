package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ExhaustiveSearch {

    public static void main(String[] args) {
//        bruteForceEnumerationOfLength3();
//        decreaseAndConquerEnumerationOfLengthN(4).forEach(System.out::println);
//        iterativeEnumerationOfLengthN(3).forEach(System.out::println);
//        divideAndConquerEnumerationOfLengthN("", 3);
        decimalStringsOfLengthN("", 4);
//        permutations("", new LinkedList<>(Arrays.asList("A","B","C")));
//        subsetHelper("", Arrays.asList("1","2", "3"));

    }

    //O(n) = 2^n. n
    private static void bruteForceEnumerationOfLength3() {
        List<Integer> integers = Arrays.asList(0, 1);
        for (int i : integers) {
            for (int j : integers) {
                for (int k : integers) {
                    System.out.println("" + i + j + k);
                }
            }
        }
    }

    //Time complexity O(n) = 2^n
    //Space complexity O(n) = 2^n
    private static List<String> decreaseAndConquerEnumerationOfLengthN(int n) {
        if (n == 1) {
            return Arrays.asList("0", "1");
        } else {
            //space complexity = O(2^n) as the subordinate will hand over a collection with
            //2^(n-1) elements and the master will need to
            List<String> list = decreaseAndConquerEnumerationOfLengthN(n - 1);
            System.out.println("Length of previous " + list.size());
            List<String> result = new ArrayList<>();
            //problem  - the top level element is doing 50% of the work
            for (String s : list) {
                result.add(s + "0");
                result.add(s + "1");
            }
            System.out.println("Length of result " + result.size());
            return result;
        }
    }

    //solves the above problem - "the top level element is doing 50% of the work"
    //but the space complexity still remains
    private static List<String> iterativeEnumerationOfLengthN(int n) {
        List<String> result = Arrays.asList("0", "1");
        for (int i = 1; i < n; i++) {
            List<String> newResult = new ArrayList<>();
            for (String s : result) {
                newResult.add(s + "0");
                newResult.add(s + "1");
                result = newResult;
            }
        }
        return result;
    }

    //depth first algorithm
    private static void divideAndConquerEnumerationOfLengthN(String partialSolution, int n) {
        if(n == 0) {
            System.out.println(partialSolution);
        }
        else {
            divideAndConquerEnumerationOfLengthN(partialSolution + "0", n-1);
            divideAndConquerEnumerationOfLengthN(partialSolution + "1", n-1);
        }
    }

    private static void decimalStringsOfLengthN(String partialSolution, int n) {
        if(n == 0) {
            System.out.println(partialSolution);
        }
        else {
            for (int i=0;i<10;i++) {
                divideAndConquerEnumerationOfLengthN(partialSolution + i, n-1);
            }
        }
    }

    private static void permutations(String partialSolution, List<String> bagOfElements) {
        if(bagOfElements.size() == 0) {
            System.out.println(partialSolution);
        }
        else {
            for(String element : bagOfElements) {
                List<String> list = new ArrayList<>(bagOfElements);
                list.remove(list.size() - 1);
                permutations(partialSolution + element, list);
            }
        }
    }

    private static void subsetHelper(String partialSolution, List<String> bagOfElements) {
        if(bagOfElements.size() == 0) {
            System.out.println("{" + partialSolution + "}");
        }
        else {
            List<String> list = new ArrayList<>(bagOfElements);
            String firstElement = list.get(0);
            list.remove(firstElement);

            subsetHelper(partialSolution, list);
            subsetHelper(partialSolution + firstElement, list);
        }
    }
}

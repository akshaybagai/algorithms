package recursion;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinatorics {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<String> bagOfwords = Arrays.asList("a", "b", "c");

        System.out.println("permutationsOrderMattersRepetitionNotAllowed");
        List<List<String>> result = new ArrayList<>();
        permutationsOrderMattersRepetitionNotAllowed(bagOfwords, strings, result, 0);
        result.forEach(System.out::println);
        System.out.println("permutationsOrderMattersRepetitionNotAllowed");

        System.out.println("permutationsOrderMattersRepetitionAllowed");
        List<List<String>> result1 = new ArrayList<>();
        permutationsOrderMattersRepetitionAllowed(bagOfwords, strings, result1, 0);
        result1.forEach(System.out::println);
        System.out.println("permutationsOrderMattersRepetitionAllowed");

        System.out.println("subsetOrderMattersRepetitionNotAllowed");
        List<List<String>> result2 = new ArrayList<>();
        subsetOrderMattersRepetitionNotAllowed(bagOfwords, strings, result2, 0);
        result2.forEach(System.out::println);
        System.out.println("subsetOrderMattersRepetitionNotAllowed");

        System.out.println("upperLowerCase");
        List<char[]> result3 = new ArrayList<>();
        char[] bagOfWords = "a123b".toCharArray();
        upperLowerCase(bagOfWords, new char[bagOfWords.length], result3, 0);
        result3.forEach(System.out::println);
        System.out.println("upperLowerCase");

        System.out.println("stringDelimitedByCharacter");
        List<char[]> result4 = new ArrayList<>();
        char[] bagOfWords2 = "a123b".toCharArray();
        stringDelimitedByCharacter(bagOfWords2, new char[bagOfWords.length*2], result4, 0, 0);
        result4.forEach(System.out::println);
        System.out.println("stringDelimitedByCharacter");

        System.out.println("stringDelimitedByCharacter2");
        List<char[]> result5 = new ArrayList<>();
        char[] bagOfWords3 = "abcbd".toCharArray();
        stringDelimitedByCharacter2(bagOfWords3, new char[bagOfWords3.length*2], result5, 0, 0);
        result5.forEach(System.out::println);
        System.out.println("stringDelimitedByCharacter2");

        List<char[]> result6 = new ArrayList<>();

        System.out.println("generate_palindromic_decompositions");

        Arrays.stream(generate_palindromic_decompositions("abcb")).forEach(System.out::println);

    }

    private static <T> void permutationsOrderMattersRepetitionNotAllowed(List<T> bagOfWords, List<T> slate, List<List<T>> result, int index) {
        if(bagOfWords.size() == index) {
            result.add(new ArrayList<>(slate));
        }
        else {
            for (int i = index; i < bagOfWords.size(); i++) {
                slate.add(bagOfWords.get(i));
                permutationsOrderMattersRepetitionNotAllowed(bagOfWords, slate, result, index + 1);
                slate.remove(slate.size() -1);
            }
        }
    }

    private static <T> void permutationsOrderMattersRepetitionAllowed(List<T> bagOfWords, List<T> slate, List<List<T>> result, int index) {
        if(bagOfWords.size() == index) {
            result.add(new ArrayList<>(slate));
        }
        else {
            for (int i = 0; i < bagOfWords.size(); i++) {
                slate.add(bagOfWords.get(i));
                permutationsOrderMattersRepetitionAllowed(bagOfWords, slate, result, index + 1);
                slate.remove(slate.size() -1);
            }
        }
    }

    private static <T> void subsetOrderMattersRepetitionNotAllowed(List<T> bagOfWords, List<T> slate, List<List<T>> result, int index) {
        if(bagOfWords.size() == index) {
            result.add(new ArrayList<>(slate));
        }
        else {
            slate.add(bagOfWords.get(index));
            subsetOrderMattersRepetitionNotAllowed(bagOfWords, slate, result, index + 1);

            slate.remove(slate.size() -1);
            subsetOrderMattersRepetitionNotAllowed(bagOfWords, slate, result, index + 1);
        }
    }

    private static void upperLowerCase(char[] bagOfWords, char[] slate, List<char[]> result, int index) {
        if(bagOfWords.length == index) {
            result.add(slate.clone());
        }
        else {
            slate[index] = bagOfWords[index];
            upperLowerCase(bagOfWords, slate, result, index + 1);

            if(Character.isAlphabetic(bagOfWords[index])) {
                slate[index] = Character.toUpperCase(bagOfWords[index]);
                upperLowerCase(bagOfWords, slate, result, index + 1);
            }
        }
    }

    private static void stringDelimitedByCharacter(char[] bagOfWords, char[] slate, List<char[]> result, int slatePosition, int currentPosition) {
        if(bagOfWords.length == currentPosition) {
            result.add(slate.clone());
        }
        else {
            slate[slatePosition] = bagOfWords[currentPosition];
            slate[slatePosition + 1] = '|';
            stringDelimitedByCharacter(bagOfWords, slate, result, slatePosition + 2, currentPosition+1);

            if(Character.isAlphabetic(bagOfWords[currentPosition])) {
                slate[slatePosition] = Character.toUpperCase(bagOfWords[currentPosition]);
                slate[slatePosition + 1] = '|';
                stringDelimitedByCharacter(bagOfWords, slate, result, slatePosition + 2, currentPosition+1);
            }
        }
    }

    private static void stringDelimitedByCharacter2(char[] bagOfWords, char[] slate, List<char[]> result, int slatePosition, int currentPosition) {
        if(bagOfWords.length == currentPosition) {
            result.add(slate.clone());
        }
        else {
            slate[slatePosition++] = bagOfWords[currentPosition];
            slate[slatePosition++] = '|';

            String pendingTerm = "";
            for (int i = currentPosition+1; i < bagOfWords.length; i++) {
                pendingTerm += bagOfWords[i];
            }
            char[] pendingTermArray = pendingTerm.toCharArray();
            if(isPalindrome(pendingTermArray)) {
                for (int i = 0; i < pendingTermArray.length; i++) {
                    slate[slatePosition++] = pendingTermArray[i];
                    currentPosition++;
                }

            }
            System.out.println(pendingTerm + " -P- " +isPalindrome(pendingTermArray));
            stringDelimitedByCharacter2(bagOfWords, slate, result, slatePosition, currentPosition+1);

//            if(Character.isAlphabetic(bagOfWords[currentPosition])) {
//                slate[slatePosition] = Character.toUpperCase(bagOfWords[currentPosition]);
//                slate[slatePosition + 1] = '|';
//                stringDelimitedByCharacter(bagOfWords, slate, result, slatePosition + 2, currentPosition+1);
//            }
        }
    }

    private static boolean isPalindrome(char[] bagOfWords) {
        for (int i = 0; i < bagOfWords.length - 1; i++) {
            if(bagOfWords[i] != bagOfWords[bagOfWords.length-1-i]) {
                return false;
            }
        }
        return true;
    }

    static String[] generate_palindromic_decompositions(String s) {
        ArrayList<String> results = new ArrayList();
        generatePalindromes(s.toCharArray(), results, new char[s.length()*2], 0, 0);
        return results.toArray(new String[results.size()]);
    }

    private static void generatePalindromes(char[] s, ArrayList<String> results, char[] curStr, int strIdx, int resultIdx) {
        System.out.println("strIdx " + strIdx);
        if (strIdx == s.length) {
            System.out.println("added");
            results.add(new String(curStr, 0, resultIdx-1));
        }
        for (int i=strIdx; i < s.length; i++ ) {
            System.out.println("strIdx " + strIdx + " i " + i);
            curStr[resultIdx] = s[i];
//            curStr[resultIdx++] = s[i];
            if (isPalendrom(s, strIdx, i)) {
//                curStr[resultIdx] = '|';
                generatePalindromes(s, results, curStr, i+1, resultIdx);
            }
//            else {
//                System.out.println("not pal");
//            }
        }

    }

    private static boolean isPalendrom(char[] st, int left, int right) {
        System.out.println("Checking " + Arrays.toString(Arrays.copyOfRange(st, left, right+1)));
        boolean isP = true;
        while (left < right) {
            if(st[left] != st[right]) {
                isP = false;
            }
            left++;
            right--;
        }
        System.out.println("P -> " + isP);
        return isP;
    }
}

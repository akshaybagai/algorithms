package problems;

import java.util.ArrayList;
import java.util.List;

public class UpperLowerCase {

    public static void main(String[] args) {
        List<String> results = new ArrayList<>();

        String input = "a12b";
        upperLowerCase(input, 0, "", results);
        results.forEach(System.out:: println);

        System.out.println("Second way");
        ArrayList<String> resultsSecond = new ArrayList<>();
        upperLowerCase2ndWay(input, 0, new char[input.length()], resultsSecond);
        resultsSecond.forEach(System.out:: println);
    }

    private static void upperLowerCase2ndWay(String input, int pointer, char[] slate, List<String> results) {
        if(pointer == input.length()) {
            String copy = new String(slate);
            results.add(copy);
        }
        else {
            char charAt = input.charAt(pointer);
            slate[pointer] = charAt;
            upperLowerCase2ndWay(input, pointer + 1, slate, results);
            if(Character.isAlphabetic(charAt)) {
                slate[pointer] = Character.toUpperCase(charAt);
                upperLowerCase2ndWay(input, pointer + 1, slate, results);
            }
        }
    }

    private static void upperLowerCase(String input, int pointer, String slate, List<String> results) {
        if(pointer == input.length()) {
            results.add(slate);
        }
        else {
            char charAt = input.charAt(pointer);
            upperLowerCase(input, pointer + 1, slate + charAt, results);
            if(Character.isAlphabetic(charAt)) {
                upperLowerCase(input, pointer + 1, slate + String.valueOf(charAt).toUpperCase(), results);
            }
        }

    }
}

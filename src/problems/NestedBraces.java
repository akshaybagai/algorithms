package problems;

import java.util.ArrayList;
import java.util.List;

public class NestedBraces {

    public static void main(String[] args) {
        List<String> results = new ArrayList<>();
        helper(3, 3, "", results);
        results.forEach(System.out:: println);
    }

    private static void helper(int left, int right, String slate, List<String> results) {
        if(left > right || left < 0 || right < 0) {return;}
        if(left == 0 && right == 0) {
            results.add(slate);
        }
        helper(left-1, right, slate + "(", results);
        helper(left, right-1, slate + ")", results);
    }
}

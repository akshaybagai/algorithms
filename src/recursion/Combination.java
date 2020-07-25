package recursion;

public class Combination {

    public static void main(String[] args) {
        System.out.println(numberOfCombinations(6,4));
    }

    private static int numberOfCombinations(int n, int k) {
        if(n <= 1) return 1;
        if(k ==0 || k==n) return 1;
        else {
            //i can make a decision to either include the element or exclude the element
            //if i choose to include the element - i have to choose k-1 elements from the remaining n-1
            //if i choose to exclude the element - i have to choose k elements from the remaining n-1
            return numberOfCombinations(n-1, k) + numberOfCombinations(n-1, k-1);
        }
    }


}

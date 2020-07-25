package recursion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(power(5,3));
    }

    private static int factorial(int num) {
        if(num == 1) {
            return 1;
        }
        else {
            return num * factorial(num - 1);
        }
    }

    private static int power(int num, int pow) {
        if(pow == 1) {
            return num;
        }
        else {
            return num * power(num, pow - 1);
        }
    }
}

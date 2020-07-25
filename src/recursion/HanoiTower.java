package recursion;

import static java.lang.String.format;

public class HanoiTower {

    public static void main(String[] args) {
        towerOfHanoi(3, 'A' , 'B', 'C');
    }

    private static void towerOfHanoi(int n, char src, char dest, char aux) {
        if (n == 1) {
            System.out.println(format("Move Source %s to destination %s", src, dest));
        }
        else {
            towerOfHanoi(n-1, src, aux, dest);
            System.out.println(format("Move Source %s to destination %s", src, dest));
            towerOfHanoi(n-1, aux, dest, src);
        }

    }
}

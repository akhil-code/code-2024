package algorithms.dynamicprogramming;

public class TilingProblem {
    public static void main(String[] args) {
        System.out.println(numberOfWays(4));
        System.out.println(numberOfWays(3));
    }

    public static int numberOfWays(int n) {
        if(n < 0) {
            return  0;
        }
        if(n == 0) {
            return 1;
        }
        return numberOfWays(n-1) + numberOfWays(n - 2);
    }
}

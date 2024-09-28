package algorithms.dynamicprogramming;

public class NumberOfWaysToReachStair {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(numberOfWays(n));
    }

    public static int numberOfWays(int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return 1;
        }
        return numberOfWays(n-1) + numberOfWays(n-2);
    }
}

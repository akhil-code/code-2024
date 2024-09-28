package algorithms.dynamicprogramming;

public class RecursivelyBreakNumbers {
    public static void main(String[] args) {
        int n = 23;
        System.out.println(breakNumbers(n));

    }

    public static int breakNumbers(int n) {
        if(n <= 0) {
            return 0;
        }

        return Math.max(n, breakNumbers(n/2) + breakNumbers(n/3) + breakNumbers(n/4));
    }
}

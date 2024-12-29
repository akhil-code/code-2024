package algorithms.amazonarchive;

public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 6;
        int ans = findFibonacci(n);
        System.out.println(ans);
    }


    private static int findFibonacci(int n) {
        int a = 1, b = 1;

        if(n <= 2) {
            return 1;
        }

        int c = Integer.MIN_VALUE;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

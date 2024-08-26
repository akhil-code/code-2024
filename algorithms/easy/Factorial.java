package algorithms.easy;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    private static long factorial(long n) {
        if(n == 0) {
            return 1;
        }
        return n * factorial(n-1);
    }
}

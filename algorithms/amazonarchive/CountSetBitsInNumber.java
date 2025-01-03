package algorithms.amazonarchive;

public class CountSetBitsInNumber {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(countBits(n));
    }

    private static int countBits(int n) {
        int count = 0;
        while(n > 0) {
            n = n & n - 1;
            count++;
        }
        return count;
    }
}

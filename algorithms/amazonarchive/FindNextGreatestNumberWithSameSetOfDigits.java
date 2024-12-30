package algorithms.amazonarchive;

import java.util.Arrays;

public class FindNextGreatestNumberWithSameSetOfDigits {

    public static void main(String[] args) {
        final String N = "218765";
        System.out.println(nextGreatestNumber(N));
    }

    private static String nextGreatestNumber(String s) {
        String[] split = s.split("");
        int n = split.length;
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = Integer.valueOf(split[i]);
        }

        int i = n - 2;
        while(i >= 0) {
            if(digits[i] < digits[n-1]) {
                swap(digits, i, n - 1);
                Arrays.sort(digits, i + 1 , n);
                break;
            }
            i--;
        }

        for (int j = 0; j < n; j++) {
            split[j] = String.valueOf(digits[j]);
        }
        return String.join("", split);
    }

    private static void swap(int[] digits, int i, int j) {
        digits[i] = digits[i] ^ digits[j];
        digits[j] = digits[i] ^ digits[j];
        digits[i] = digits[i] ^ digits[j];
    }

}

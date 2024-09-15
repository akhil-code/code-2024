package algorithms.dynamicprogramming;

import java.util.Arrays;

public class MaximumLengthOfChainPairs {

    public static void main (String[] args) {
        int n = 5;
        int[][] p = {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};
        // Function Call
        System.out.println(maxChainLen(p, n));
    }

    public static int maxChainLen(int[][] pairs, int n) {
        int maxLength = 0;
        Arrays.sort(pairs, (a1, a2) -> a1[1] - a2[1]);
        // greedy approach
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(pairs[i][0] > prev) {
                prev = pairs[i][0];
                maxLength++;
            }
        }

        return maxLength;
    }
}

package algorithms.dynamicprogramming;

import java.util.Arrays;

public class MaximumSegmentsOfThreeLengths {
    public static void main(String[] args) {
        int n = 17, a = 1, b = 2, c = 3;

        // Function call
        System.out.println(maximumSegments(n, a, b, c));
    }

    public static int maximumSegments(int n, int a, int b, int c) {
        int[] arr = {a, b, c};
        int[][] dp = new int[3][n+1];
        for (int i = 0; i < 3; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = 0;
                if(i-1 >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
                }

                if(j == arr[i]) {
                    dp[i][j] = Math.max(1, dp[i][j]);
                } else if(j-arr[i] > 0 && dp[i][j-arr[i]] > 0) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i][j-arr[i]]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        int maxValue = 0;
        for (int i = 0; i < 3; i++) {
            maxValue = Math.max(maxValue, dp[i][n]);
        }

        return maxValue;
    }
}

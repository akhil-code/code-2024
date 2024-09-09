package algorithms.dynamicprogramming;

import datastructures.arrays.ArrUtil;

public class BinomialCoefficient {
    public static void main(String[] args) {
        int n = 5, r = 2;
        int ans = binomialCoefficient(n, r);
        System.out.println(ans);
    }

    private static int binomialCoefficient(int n, int r) {
        int[][] dp = new int[r+1][n+1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= r; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
            }
        }
        // ArrUtil.print2DArray(dp);
        return dp[r][n];
    }
}

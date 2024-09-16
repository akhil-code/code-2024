package algorithms.dynamicprogramming;

import java.util.Arrays;

public class GoldMining {
    public static void main(String[] args)
    {
        int[][] gold = { { 1, 3, 1, 5 },
                { 2, 2, 4, 1 },
                { 5, 0, 2, 3 },
                { 0, 6, 1, 2 } };
        int m = 4, n = 4;
        System.out.println(getMaxGold(gold, n, m));
    }

    public static int getMaxGold(int[][] gold, int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][n-1] = gold[i][n-1];
        }

        for (int j = n-2; j >=0 ; j--) {
            for (int i = 0; i < m; i++) {
                dp[i][j] = Math.max(dp[i][j], dp[i][j+1]);
                if(i-1 >=0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j+1]);
                }
                if(i+1 < m) {
                    dp[i][j] = Math.max(dp[i][j], dp[i+1][j+1]);
                }
                dp[i][j] += gold[i][j];
            }
        }

        int maxGold = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return maxGold;
    }
}

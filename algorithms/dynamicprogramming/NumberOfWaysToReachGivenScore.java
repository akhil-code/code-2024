package algorithms.dynamicprogramming;

public class NumberOfWaysToReachGivenScore {
    public static void main(String[] args) {
        int n = 20;
        System.out.println("Count for " + n + " is "
                + count(n));

        n = 13;
        System.out.println("Count for " + n + " is "
                + count(n));
    }

    public static int count(int n) {
        int[] scores = {3, 5, 10};
        int[][] dp = new int[4][n+1];
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 0; i <= 3; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= n ; j++) {
                dp[i][j] = dp[i-1][j];
                if(j-scores[i-1] >= 0) {
                    dp[i][j] += dp[i][j-scores[i-1]];
                }
            }
        }


        return dp[3][n];
    }
}

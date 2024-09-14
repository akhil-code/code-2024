package algorithms.dynamicprogramming;

public class CoinChange {

    // Driver Function to test above function
    public static void main(String args[])
    {
        int coins[] = { 1, 2, 3 };
        int n = coins.length;
        int sum = 5;
        System.out.println(coinChange(coins, n, sum));
        System.out.println(spaceOptimizedCoinChange(coins, n, sum));
    }


    public static int coinChange(int[] coins, int m, int sum) {
        int[][] dp = new int[m+1][sum+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j <= sum; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if(j - coins[i-1] >= 0) {
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][sum];
    }

    public static int spaceOptimizedCoinChange(int[] coins, int m, int sum) {
        int[] dp = new int[sum+1];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[sum];
    }
}

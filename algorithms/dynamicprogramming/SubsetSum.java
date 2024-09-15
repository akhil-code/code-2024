package algorithms.dynamicprogramming;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        if (subsetSumOptimized(arr, sum))
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");
    }

    public static boolean isSubsetSum(int[] arr, int sum) {
        int m = arr.length;
        boolean[][] dp = new boolean[m+1][sum+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if(j-arr[i-1] >= 0) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-arr[i-1]];
                }

            }
        }

        return dp[m][sum];
    }

    public static boolean subsetSumOptimized(int[] arr, int sum) {
        int m = arr.length;
        boolean[] prev = new boolean[sum+1];
        boolean[] curr = new boolean[sum+1];
        prev[0] = curr[0] = true;

        for (int i = 1; i <= sum; i++) {
            prev[i] = false;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= sum; j++) {
                curr[j] = prev[j];
                if(j-arr[i] >= 0) {
                    curr[j] = curr[j] || prev[j-arr[i]];
                }
            }
            prev = curr.clone();
        }
        return curr[sum];
    }
}

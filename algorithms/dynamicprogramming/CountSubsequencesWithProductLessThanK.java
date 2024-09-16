package algorithms.dynamicprogramming;

import java.util.Arrays;

public class CountSubsequencesWithProductLessThanK {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4};
        int k = 10;
        System.out.println(productSubSeqCount(arr, k));
    }

    public static int productSubSeqCount(int[] arr, int sum) {
        int m = arr.length;
        int[][] dp = new int[m+1][sum+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= sum; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if(arr[i-1] == j) {
                    dp[i][j] += 1;
                }
                if(j % arr[i-1] == 0) {
                    dp[i][j] += dp[i-1][j/arr[i-1]];
                }
            }
        }

        int totalSum = 0;
        for (int j = 0; j <= sum; j++) {
            totalSum += dp[m][j];
        }
        return totalSum;
    }
}

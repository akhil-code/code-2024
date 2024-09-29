package algorithms.dynamicprogramming;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        System.out.println(matrixMultiplications(arr));
    }

    public static int matrixMultiplications(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n; i++) {
                int j = i + length - 1;
                if(j < n) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i+1; k <= j-1; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + arr[i]*arr[j]*arr[k]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}

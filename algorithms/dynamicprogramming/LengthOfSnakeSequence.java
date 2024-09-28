package algorithms.dynamicprogramming;

public class LengthOfSnakeSequence {
    public static void main(String[] args) {
        int mat[][] = {{9, 6, 5, 2},
                {8, 7, 6, 5},
                {7, 3, 1, 6},
                {1, 1, 1, 7}};

        findSnakeSequence(mat);
    }

    public static void findSnakeSequence(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int j = n-1; j >= 0 ; j--) {
            for (int i = n-1; i >= 0 ; i--) {
                dp[i][j] = 0;
                if(i+1 < m && Math.abs(mat[i][j] - mat[i+1][j]) == 1) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i+1][j]);
                }
                if(j+1 < n && Math.abs(mat[i][j] - mat[i][j+1]) == 1) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i][j+1]);
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        System.out.println(maxLength);
    }
}

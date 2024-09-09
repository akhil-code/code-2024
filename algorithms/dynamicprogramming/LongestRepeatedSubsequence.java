package algorithms.dynamicprogramming;

public class LongestRepeatedSubsequence {
    public static void main(String[] args) {
        String str = "AABEBCDD";
        System.out.println(findLongestRepeatedSubsequence(str));
    }

    public static int findLongestRepeatedSubsequence(String s) {
        int n = s.length();

        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(s.charAt(i-1) == s.charAt(j-1) && i-1 != j-1) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}

package algorithms.dynamicprogramming;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "practicewritegeekscourses";
        System.out.println(maxCommStr(s1, s2));
    }

    public static int maxCommStr(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();

        int[][] dp = new int[n1+1][n2+1];
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= n2; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                maxValue = Math.max(dp[i][j], maxValue);
            }
        }
        return maxValue;
    }
}

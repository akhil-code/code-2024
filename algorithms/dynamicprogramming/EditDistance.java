package algorithms.dynamicprogramming;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "GEEXSFRGEEKKS", s2 = "GEEKSFORGEEKS";
        System.out.println(editDistance(s1, s2));
    }

    public static int editDistance(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }


        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[n1][n2];
    }
}

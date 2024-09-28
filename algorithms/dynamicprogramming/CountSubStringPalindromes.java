package algorithms.dynamicprogramming;

public class CountSubStringPalindromes {
    public static void main(String[] args) {
        System.out.println(countPalindromes("abaab"));
        System.out.println(countPalindromes("aaa"));
    }

    public static int countPalindromes(final String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i >= j) {
                    dp[i][j] = true;
                }
            }
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n; i++) {
                int j = i + length - 1;
                if(j >= n) {
                    continue;
                }

                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = false;
                }

                if(dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}

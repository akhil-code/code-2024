package algorithms.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class PrintAllPalindromeSubstrings {
    public static void main(String[] args) {
        printAllPalindromeSubstrings("abaab");

    }

    public static void printAllPalindromeSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i >= j) {
                    dp[i][j] = true;
                }
            }
        }

        Set<String> palindromes = new HashSet<>();

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
                    palindromes.add(s.substring(i, j+1));
                }
            }
        }

        palindromes.forEach(str -> System.out.println(str));
    }
}

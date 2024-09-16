package algorithms.dynamicprogramming;

import java.util.Arrays;

public class FriendsPairing {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(numberOfPairs(n));
    }

    public static int numberOfPairs(int n) {
        if(n <= 2) {
            return n;
        }

        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            if(i <= 2) {
                dp[i] = i;
            } else {
                dp[i] = dp[i-1] + (i-1) * dp[i-2];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}

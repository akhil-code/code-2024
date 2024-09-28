package algorithms.dynamicprogramming;

import java.util.Arrays;

public class LargestDivisibleSubset {
    public static void main(String[] args)
    {
        int[] a = { 10, 5, 3, 15, 20};
        System.out.println(largestSubset(a));
    }

    public static int largestSubset(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        for (int i = n-1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i+1; j < n; j++) {
                if(sortedArr[j] % sortedArr[i] == 0) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        System.out.println(Arrays.toString(sortedArr));
        System.out.println(Arrays.toString(dp));

        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            maxCount = Math.max(dp[i], maxCount);
        }
        return maxCount;
    }
}

package algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LongestSubsequenceWithAdjacentDifferenceAsOne {
    public static void main(String[] args) {
        System.out.println(longestSubseqWithDiffOne(new int[]{ 1, 2, 3, 4, 5, 3, 2 }));
        System.out.println(longestSubseqWithDiffOne(new int[]{10, 9, 4, 5, 4, 8, 6}));
    }

    public static int longestSubseqWithDiffOne(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int before = arr[i] - 1;
            int after = arr[i] + 1;
            dp[i] = 1;

            if(map.containsKey(before)) {
                int beforeIndex = map.get(before);
                dp[i] =  Math.max(1 + dp[beforeIndex], dp[i]);
            }

            if(map.containsKey(after)) {
                int afterIndex = map.get(after);
                dp[i] = Math.max(1 + dp[afterIndex], dp[i]);
            }

            if(map.containsKey(arr[i])) {
               if(dp[i] > dp[map.get(arr[i])]) {
                   map.put(arr[i], i);
               }
            } else {
                map.put(arr[i], i);
            }
        }

        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}

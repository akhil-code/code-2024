package algorithms.amazonarchive;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayDivisibleByK {
    public static void main(String[] args) {
        int arr[] = { 2, 7, 6, 1, 4, 5 };
        int n = arr.length;
        int k = 3;

        System.out.println("Length = " + longestDivisibleSubarray(arr, k));
    }

    private static int longestDivisibleSubarray(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        int currSum = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            int remainder = currSum % k;
            remainder = remainder >= 0 ? remainder : (remainder + k) % k;

            if(map.containsKey(remainder)) {
                maxLength = Math.max(maxLength, i - map.get(remainder));
            } else {
                map.put(remainder, i);
            }
        }
        return maxLength;
    }

}

package algorithms.array;

import java.util.Arrays;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;
        System.out.println(findMinDiff(arr, m));
    }

    public static int findMinDiff(int[] arr, int m) {
        int i = 0;
        int n = arr.length;
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        while(i < n && i + m - 1 < n) {
            int j = i + m - 1;
            int diff = arr[j] - arr[i];
            minDiff = Math.min(diff, minDiff);
            i++;
        }
        return minDiff;
    }
}

package algorithms.dynamicprogramming;

import java.util.Arrays;

public class MaximumSumBitonicSequence {
    public static void main(String[] args)
    {
        int arr[] = { 1, 15, 51, 45, 33, 100, 12, 18, 9 };
        int n = arr.length;
        System.out.println("Maximum Sum : " + MaxSumBS(arr, n));
    }

    public static int MaxSumBS(int[] arr, int n) {
        int[] lisSum = new int[n];
        int[] ldsSum = new int[n];

        for (int i = 0; i < n; i++) {
            lisSum[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    lisSum[i] = Math.max(lisSum[i], lisSum[j] + arr[i]);
                }
            }
        }

        for (int i = n-1; i >= 0; i--) {
            ldsSum[i] = arr[i];
            for (int j = n-1; j > i; j--) {
                if(arr[j] < arr[i]) {
                    ldsSum[i] = Math.max(ldsSum[i], ldsSum[j] + arr[i]);
                }
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(lisSum));
        System.out.println(Arrays.toString(ldsSum));

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, lisSum[i] + ldsSum[i] - arr[i]);
        }
        return maxSum;
    }
}

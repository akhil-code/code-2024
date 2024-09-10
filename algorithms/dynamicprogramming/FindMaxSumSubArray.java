package algorithms.dynamicprogramming;

public class FindMaxSumSubArray {

    public static void main(String[] args) {
        int arr[] = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(findMaxSumSubarray(arr));
    }

    public static int findMaxSumSubarray(int[] arr) {
        int n = arr.length;
        int currSum = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < n; i++) {
            currSum = Math.max(arr[i] + currSum, arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}

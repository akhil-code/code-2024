package algorithms.dynamicprogramming;

public class MaxSumPathAcrossTwoSortedArrays {
    public static void main(String[] args) {
        int ar1[] = { 2, 3, 7, 10, 12, 15, 30, 34 };
        int ar2[] = { 1, 5, 7, 8, 10, 15, 16, 19 };

        System.out.println("Maximum sum path is :" + maxPathSum(ar1, ar2));
    }

    public static int maxPathSum(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        int sum1 = 0;
        int sum2 = 0;
        int totalMaxSum = 0;

        int i = 0, j = 0;
        while(i < m && j < n) {
            if(arr1[i] < arr2[j]) {
                sum1 += arr1[i];
                i++;
            } else if(arr1[i] > arr2[j]) {
                sum2 += arr2[j];
                j++;
            } else {
                totalMaxSum += Math.max(sum1, sum2) + arr1[i];
                sum1 = sum2 = 0;
                i++;
                j++;
            }
        }

        // add left over arrays
        while(i < m) {
            sum1 += arr1[i++];
        }

        while(j < n) {
            sum2 += arr2[j++];
        }
        totalMaxSum += Math.max(sum1, sum2);

        return totalMaxSum;
    }
}

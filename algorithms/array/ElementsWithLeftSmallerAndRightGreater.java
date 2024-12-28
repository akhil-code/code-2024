package algorithms.array;

import java.util.Arrays;

public class ElementsWithLeftSmallerAndRightGreater {
    public static void main(String[] args)
    {
        int arr[] = { 5, 1, 4, 3, 6, 8, 10, 7, 9 };
        int n = arr.length;
        System.out.println("element is " + findElement(arr, n));
    }

    public static int findElement(int[] arr, int n) {
        int[] smallestElementRight = new int[n];
        int largestSoFar = Integer.MIN_VALUE;

        smallestElementRight[n-1] = Integer.MAX_VALUE;

        for (int i = n-2; i >= 0; i--) {
            smallestElementRight[i] = Math.min(arr[i+1], smallestElementRight[i+1]);
        }



        for (int i = 0; i < n; i++) {
            if(i >= 1) {
                largestSoFar = Math.max(largestSoFar, arr[i-1]);
            }

            if(arr[i] > largestSoFar && arr[i] < smallestElementRight[i]) {
                return arr[i];
            }
        }

        return -1;
    }
}

package algorithms.amazonarchive;

public class DivideAnArrayIntoTwoArraysOfEqualAverage {

    public static void main (String[] args)
    {
        int[] arr = {1, 5, 7, 2, 0};
        int n = arr.length;
        int midPoint = findSubarrays(arr, n);
        System.out.println(midPoint);
        System.out.println("0 -> " + midPoint);
        System.out.println((midPoint + 1) + " -> " + (n - 1));
    }

    private static int findSubarrays(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += arr[i];

            if(currSum/(i+1) == (sum - currSum) / (n - i - 1)) {
                return i;
            }
        }
        return -1;
    }
}

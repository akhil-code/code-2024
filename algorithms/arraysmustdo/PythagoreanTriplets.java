package algorithms.arraysmustdo;

import java.util.Arrays;

public class PythagoreanTriplets {
    public static void main(String[] args) {
        int ar[] = { 3, 1, 4, 6, 5 };
        if (isTriplet(ar))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static boolean isTriplet(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int c = arr[i];
            if(FindPairThatSumToKInSortedArray.findPairs(Arrays.copyOfRange(arr, 0, i), c) != null) {
                return true;
            }
        }
        return false;
    }
}

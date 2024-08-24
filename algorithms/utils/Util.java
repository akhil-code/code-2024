package algorithms.utils;

public class Util {

    /**
     * Swap two elements in the array indexed at i and j.
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int n = arr.length;
        if (i >= n || j >= n) {
            throw new IndexOutOfBoundsException(String.format("i: {}, j: {}", i, j));
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

package algorithms.sorting.comparision;

import algorithms.sorting.Sorter;
import algorithms.utils.Util;


/**
 * repeatedly compare adjacent elements in array and rearrange accordingly.
 */
public class BubbleSort implements Sorter {
    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    Util.swap(arr, j, j+1);
                }
            }
        }
        return arr;
    }
}

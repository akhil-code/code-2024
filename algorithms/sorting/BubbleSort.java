package algorithms.sorting;

import algorithms.utils.Util;

import java.util.Arrays;

/**
 * repeatedly compare adjacent elements in array and rearrange accordingly.
 */
public class BubbleSort implements Sorter {
    @Override
    public int[] sort(int[] arr) {
        System.out.println(String
                .format("Applying Bubble sort on %s", Arrays.toString(arr)));
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if(arr[j] > arr[j+1]) {
                    Util.swap(arr, j, j+1);
                }
            }
        }
        return arr;
    }
}

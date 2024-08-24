package algorithms.sorting;

import algorithms.utils.Util;

import java.util.Arrays;

public class SelectionSort implements Sorter {
    @Override
    public int[] sort(int[] arr) {
        System.out.println(String.format("Applying selection sort on %s", Arrays.toString(arr)));
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i] > arr[j]) {
                    Util.swap(arr, i, j);
                }
            }
        }
        return arr;
    }

}
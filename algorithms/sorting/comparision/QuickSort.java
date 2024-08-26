package algorithms.sorting.comparision;

import algorithms.sorting.Sorter;
import algorithms.utils.Util;

public class QuickSort implements Sorter {
    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        quicksort(arr, 0, n-1);
        return arr;
    }

    void quicksort(int[] arr, int left, int right) {
        if(left < right) {
            int partitionIndex = partition(arr, left, right);
            quicksort(arr, left, partitionIndex - 1);
            quicksort(arr, partitionIndex + 1, right);
        }
    }

    int partition(int[] arr, int left, int right) {
        int lastElement = arr[right];
        int wall = left;
        for (int l = left; l < right; l++) {
            if(arr[l] < lastElement) {
                Util.swap(arr, wall, l);
                wall++;
            }
        }
        Util.swap(arr, wall, right);
        return wall;
    }

}

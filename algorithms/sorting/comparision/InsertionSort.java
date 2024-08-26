package algorithms.sorting.comparision;

import algorithms.sorting.Sorter;

public class InsertionSort implements Sorter {
    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int target = arr[i];
            int j = i - 1;
            while(j >= 0 && target < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = target;
        }
        return arr;
    }
}

package algorithms.sorting.comparision;

import algorithms.sorting.Sorter;

import java.util.Arrays;

public class MergeSort implements Sorter {
    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        mergeSort(arr, 0, n-1);
        return arr;
    }

    private void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            arr2[j] = arr[middle + 1 + j];
        }
        int i = 0, j = 0, k = left;

        while(i < n1 && j < n2) {
            if(arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while(j < n2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }
}
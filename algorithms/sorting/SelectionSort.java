package algorithms.sorting;

import algorithms.utils.Util;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println("Selection sort algorithm");
        int[] inputArray = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(selectionSort(inputArray)));
    }


    public static int[] selectionSort(int arr[]) {
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
package datastructures.heaps;

import datastructures.arrays.ArrUtil;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] inputArray = ArrUtil.createRandomArrayOfLength(10, 0, 20);
        System.out.println("input Array: " + Arrays.toString(inputArray));
        int[] sortedArray = heapSort(inputArray);
        System.out.println("sorted Array: " + Arrays.toString(sortedArray));
    }

    public static int[] heapSort(int[] arr) {
        int n = arr.length;
        // create max heap
        int[] maxHeap = Creation.createMaxHeapFromArray(arr);
        for (int i = 0; i < n; i++) {
            HeapUtil.swap(maxHeap, 0, n-i-1);
            HeapUtil.maxHeapify(arr, n-i-1, 0);
        }
        return maxHeap;
    }
}

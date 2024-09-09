package datastructures.heaps;

import datastructures.arrays.ArrUtil;

import java.util.Arrays;

public class Deletion {
    public static void main(String[] args) {
        int[] minHeap = Creation.createMaxHeapFromArray(ArrUtil.createRandomArrayOfLength(10, 0, 100));
        int deleteTarget = minHeap[4];
        System.out.println("minHeap" + Arrays.toString(minHeap));

        minHeap = deleteFromMinHeap(minHeap, deleteTarget);
        System.out.println("minHeap" + Arrays.toString(minHeap));
    }

    public static int[] deleteFromMinHeap(int[] minHeap, int target) {
        // search target
        int deleteIndex = searchElement(minHeap, target);
        minHeap[deleteIndex] = Integer.MIN_VALUE;

        int i = deleteIndex;
        while(HeapUtil.parent(i) >= 0 && minHeap[i] < minHeap[HeapUtil.parent(i)]) {
            HeapUtil.swap(minHeap, i, HeapUtil.parent(i));
            i = HeapUtil.parent(i);
        }

        return ExtractMinMaxInHeap.extractMinFromMinHeap(minHeap);
    }

    private static int searchElement(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

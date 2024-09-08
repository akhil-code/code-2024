package datastructures.heaps;

import datastructures.arrays.ArrUtil;

import java.util.Arrays;

public class ExtractMinMaxInHeap {
    public static void main(String[] args) {
        int[] minHeap = Creation.createMinHeapFromArray(ArrUtil.createRandomArrayOfLength(10, 0, 100));
        System.out.println("minheap: " + Arrays.toString(minHeap));

        minHeap = extractMinFromMinHeap(minHeap);
        System.out.println("minheap: " + Arrays.toString(minHeap));

    }

    public static int[] extractMinFromMinHeap(int[] heap) {
        int n = heap.length;
        int minElement = heap[0];
        heap[0] = heap[n - 1];
        int[] newHeap = Arrays.copyOf(heap, n-1);

        HeapUtil.maxHeapify(newHeap, 0);

        return newHeap;
    }
}

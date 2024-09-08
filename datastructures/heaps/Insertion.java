package datastructures.heaps;

import java.util.Arrays;

public class Insertion {

    public static void main(String[] args) {
        int[] arr = {10, 12, 43, 54, 5, 63 ,17};
        // Min heap insertion
        arr = Creation.createMinHeapFromArray(arr);
        arr = insertToMinHeap(arr, 20);
        arr = insertToMinHeap(arr, 12);
        arr = insertToMinHeap(arr, 10);
        arr = insertToMinHeap(arr, 5);
        arr = insertToMinHeap(arr, 44);
        arr = insertToMinHeap(arr, 23);
        System.out.println(Arrays.toString(arr));

        // max heap insertion
        arr = Creation.createMaxHeapFromArray(arr);
        arr = insertToMaxHeap(arr, 1000);
        System.out.println(Arrays.toString(arr));

    }

    public static int[] insertToMinHeap(int[] heapArr, int target) {
        int n = heapArr.length;
        int[] newHeap = Arrays.copyOf(heapArr, n+1);
        newHeap[n] = target;

        while(HeapUtil.parent(n) >= 0 && newHeap[n] < newHeap[HeapUtil.parent(n)]){
            HeapUtil.swap(newHeap, n, HeapUtil.parent(n));
            n = HeapUtil.parent(n);
        }

        HeapUtil.minHeapify(heapArr, n);

        return newHeap;
    }

    public static int[] insertToMaxHeap(int[] arr, int target) {
        int n = arr.length;
        int[] newHeap = Arrays.copyOf(arr, n + 1);
        newHeap[n] = target;

        while(newHeap[n] > newHeap[HeapUtil.parent(n)]) {
            HeapUtil.swap(newHeap, n, HeapUtil.parent(n));
            n = HeapUtil.parent(n);
        }
        return newHeap;
    }
}

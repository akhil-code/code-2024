package datastructures.heaps;

import java.util.Arrays;

public class Creation {
    public static void main(String[] args) {
        int[] arr = {10, 12, 43, 54, 5, 63 ,17, 20};
        System.out.println(Arrays.toString(createMinHeapFromArray(arr)));
        System.out.println(Arrays.toString(createMaxHeapFromArray(arr)));
    }

    public static int[] createMinHeapFromArray(int[] arr) {
        int n = arr.length;
        for(int i = n/2 ; i >= 0; i--) {
            HeapUtil.minHeapify(arr, i);
        }
        return arr;
    }

    public static int[] createMaxHeapFromArray(int[] arr) {
        int n = arr.length;
        for(int i = n /2 ; i >= 0; i--) {
            HeapUtil.maxHeapify(arr, i);
        }
        return arr;
    }
}

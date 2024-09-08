package datastructures.heaps;

import java.util.Arrays;

import static datastructures.heaps.Creation.createMaxHeapFromArray;
import static datastructures.heaps.Creation.createMinHeapFromArray;

public class GetSmallestLargestElement {
    public static void main(String[] args) {
        int[] arr = {10, 12, 43, 54, 5, 63 ,17, 20};
        arr = createMinHeapFromArray(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(getMinFromMinHeap(arr));

        arr = createMaxHeapFromArray(arr);
        System.out.println(getMaxFromMaxHeap(arr));
    }

    public static int getMinFromMinHeap(int[] arr) {
        int n = arr.length;
        if(n > 0) {
            return arr[0];
        }
        return -1;
    }

    public static int getMaxFromMaxHeap(int[] arr) {
        int n = arr.length;
        if(n > 0) {
            return arr[0];
        }
        return -1;
    }
}

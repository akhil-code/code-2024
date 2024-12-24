package algorithms.array;

import datastructure.heap.MaxHeap;

import java.util.Arrays;

public class KthSmallestElement {
    // Driver's code:
    public static void main(String[] args) {
        int N = 10;
        int[] arr = { 10, 5, 4, 3, 48, 6, 2, 33, 53, 10 };
        int K = 4;

        // Function call
        System.out.println("Kth Smallest Element is: " + kthSmallest(arr, N, K));
    }

    public static int kthSmallest(int[] arr, int n, int k) {
        MaxHeap maxHeap = new MaxHeap(0);
        // O(n)
        maxHeap.createFromArray(Arrays.copyOf(arr, k));

        // O(n-k) * log(k)
        for (int i = k; i < n; i++) {
            if(maxHeap.getMax() > arr[i]) {
                maxHeap.replaceRoot(arr[i]);
                maxHeap.heapify(0);
            }
        }
        maxHeap.printHeap();
        return maxHeap.getMax();
    }
}

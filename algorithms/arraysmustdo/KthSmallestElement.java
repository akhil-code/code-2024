package algorithms.arraysmustdo;

import java.util.Arrays;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 19};
        int K = 2;
        System.out.print("K'th smallest element: " + findKthSmallestElement(arr, K));
    }

    public static int findKthSmallestElement(int[] arr, int k) {
        Heap maxHeap = new Heap();
        maxHeap.createMaxHeapFromArray(Arrays.copyOfRange(arr, 0, k));

        for (int i = k; i < arr.length; i++) {
            if(arr[i] < maxHeap.getMaxElement()) {
                maxHeap.replaceMaxElementAndHeapify(arr[i]);
            }
        }
        return maxHeap.getMaxElement();
    }



    static class Heap {
        int n;
        int[] h;

        public int getMaxElement() {
            return this.h[0];
        }

        public void replaceMaxElementAndHeapify(int target) {
            this.h[0] = target;
            this.maxHeapify(0);
        }

        public void printHeap() {
            System.out.println(Arrays.toString(this.h));
        }

        public void createMaxHeapFromArray(int[] arr) {
            this.n = arr.length;
            this.h = arr.clone();

            for (int i = n/2; i >= 0; i--) {
                maxHeapify(i);
            }
        }

        private void maxHeapify(int i) {
            if(i >= n) {
                return;
            }

            int leftIndex = left(i);
            int rightIndex = right(i);
            int largestIndex = i;

            if(leftIndex < n && h[leftIndex] > h[largestIndex]) {
                largestIndex = leftIndex;
            }

            if(rightIndex < n && h[rightIndex] > h[largestIndex]) {
                largestIndex = rightIndex;
            }

            if(largestIndex != i) {

                System.out.println(Arrays.toString(this.h));
                swap(h, largestIndex, i);
                maxHeapify(largestIndex);
                System.out.println(Arrays.toString(this.h));

            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        private int left(int i) {
            return 2*i+1;
        }

        private int right(int i) {
            return 2*i+2;
        }

        private int parent(int i) {
            return (i-1)/2;
        }
    }


}

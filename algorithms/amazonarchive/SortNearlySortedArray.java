package algorithms.amazonarchive;

import java.util.Arrays;

public class SortNearlySortedArray {
    public static void main(String[] args){
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };

        // function call
        kSort(arr, k);
    }

    private static void kSort(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n];

        final MinHeap minHeap = new MinHeap();
        minHeap.createHeapFromArray(Arrays.copyOf(arr, k));

        int i = 0;
        while(i + k < n) {
            ans[i] = minHeap.extractMin();
            minHeap.insert(arr[k + i]);
            i++;
        }

        while(minHeap.size() > 0) {
            ans[i++] = minHeap.extractMin();
        }

        System.out.println(Arrays.toString(ans));

    }

    public static class MinHeap {
        int[] arr;
        int maxSize;
        int n;

        public int size() {
            return n;
        }

        public void createHeapFromArray(int[] arr) {
            this.arr = Arrays.copyOf(arr, arr.length);
            this.n = arr.length;
            this.maxSize = n;

            for (int i = n / 2; i >= 0; i--) {
                heapify(i);
            }
        }

        public void printHeap() {
            System.out.println(Arrays.toString(arr));
        }

        public int getMin() {
            return arr[0];
        }

        public void insert(int x) {
            n++;
            arr[n - 1] = x;
            int i = n - 1;
            while(arr[parent(i)] > arr[i]) {
                swap(arr, i, parent(i));
                i = parent(i);
            }
        }

        public int extractMin() {
            int minElement = arr[0];
            arr[0] = arr[n - 1];
            n--;

            heapify(0);
            return minElement;
        }

        private void heapify(int i) {
            int smallest = i;

            if(left(i) < n && arr[left(i)] < arr[smallest]) {
                smallest = left(i);
            }

            if(right(i) < n && arr[right(i)] < arr[smallest]) {
                smallest = right(i);
            }

            if(smallest != i) {
                swap(arr, i, smallest);
                heapify(smallest);
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        private int left(int i) {
            return 2 * i + 1;
        }

        private int right(int i) {
            return 2 * i + 2;
        }

        private int parent(int i) {
            return (i - 1) / 2;
        }
    }
}

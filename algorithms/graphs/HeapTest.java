package algorithms.graphs;

import java.util.Arrays;
import java.util.Random;

public class HeapTest {

    public static void main(String[] args) {
        Heap heap = new Heap(6);
        int[] arr = {12, 70, 28, 82, 73, 52};
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            heap.insert(arr[arr.length - i - 1]);
        }

        heap.printHeap();
        System.out.println(Arrays.toString(heap.sort()));
    }

    public static class Heap {
        int maxSize;
        int currSize;
        int[] arr;

        public Heap(int maxSize) {
            this.currSize = 0;
            this.maxSize = maxSize;
            this.arr = new int[maxSize];
        }

        public int[] sort() {
            for (int i = 0; i < maxSize; i++) {
                int currElement = extractMin();
                arr[maxSize - i - 1] = currElement;
            }
            return Arrays.copyOf(arr, arr.length);
        }

        public void printHeap() {
            System.out.println(Arrays.toString(arr));
        }

        public int getMin() {
            System.out.println(Arrays.toString(arr));
            return this.arr[0];
        }

        public int extractMin() {
            if(currSize <= 0) {
                System.out.println("Empty heap");
                return -1;
            }

            int result = arr[0];
            arr[0] = arr[currSize - 1];
            currSize--;
            heapify(0);
            return result;
        }

        public void insert(int data) {
            if(currSize >= maxSize) {
                System.out.println("Cannot insert more elements");
                return;
            }
            currSize++;
            this.arr[currSize - 1] = data;

            int i = currSize - 1;
            while(i >= 0 && parent(i) >=0 && arr[i] < arr[parent(i)]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        public void createMinHeapFromArray(int[] inputArr) {
            this.currSize = inputArr.length;
            arr = Arrays.copyOf(inputArr, inputArr.length);
            for (int i = inputArr.length/2; i >= 0; i--) {
                heapify(i);
            }
        }

        public void heapify(int i) {
            int smallestIndex = i;
            if(left(i) < currSize && arr[left(i)] < arr[smallestIndex]) {
                smallestIndex = left(i);
            }
            if(right(i) < currSize && arr[right(i)] < arr[smallestIndex]) {
                smallestIndex = right(i);
            }
            if(smallestIndex != i) {
                swap(i, smallestIndex);
                heapify(smallestIndex);
            }
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

        private void swap(int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

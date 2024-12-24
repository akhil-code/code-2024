package datastructure.heap;

import java.util.Arrays;

public class MaxHeap {

    int n;
    int maxSize;
    int[] arr;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
    }

    public void createFromArray(int[] inputArray) {
        this.n = inputArray.length;
        this.maxSize = inputArray.length;
        this.arr = Arrays.copyOf(inputArray, inputArray.length);

        for (int i = n/2; i >= 0; i--) {
            heapify(i);
        }
    }

    public void replaceRoot(int newValue) {
        arr[0] = newValue;
        heapify(0);
    }

    public void printHeap() {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public void heapify(int i) {
        int largest = i;

        if(left(i) < n && arr[left(i)] > arr[largest]) {
            largest = left(i);
        }

        if(right(i) < n && arr[right(i)] > arr[largest]) {
            largest = right(i);
        }

        if(largest != i) {
            swap(arr, largest, i);
            heapify(largest);
        }

    }

    public int getMax() {
        return arr[0];
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

    public static void main(String[] args) {
        int[] inputArr = {1, 5, 11, 45, 0};
        MaxHeap maxHeap = new MaxHeap(5);
        maxHeap.createFromArray(inputArr);
        maxHeap.printHeap();


    }
}

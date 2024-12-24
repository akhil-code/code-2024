package datastructure.heap;

import java.util.Arrays;

public class MinHeap {
    int maxSize;
    int n;
    int[] arr;

    public MinHeap(int maxSize) {
        this.n = 0;
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public int getMin() {
        return this.arr[0];
    }

    // the new key should be less than the current value
    public void decreaseKey(int target, int newValue) {
        if(newValue > target) {
            System.out.println("Error: Unable to decrease key with higher value");
            return;
        }
        int targetIndex = searchKey(target);
        arr[targetIndex] = newValue;

        while(arr[targetIndex] < arr[parent(targetIndex)]) {
            swap(this.arr, targetIndex, parent(targetIndex));
            targetIndex = parent(targetIndex);
        }
    }

    public int extractMin() {
        int minNode = this.arr[0];
        this.arr[0] = this.arr[n - 1];
        this.n--;

        heapify(0);
        return minNode;
    }

    public void createFromArray(int[] inputArr) {
        this.maxSize = inputArr.length;
        this.n = inputArr.length;
        this.arr = Arrays.copyOf(inputArr, inputArr.length);

        for (int i = n/2; i >= 0; i--) {
            heapify(i);
        }
    }


    public void heapify(int i) {
        int smallest = i;
        if(left(i) < this.n && arr[left(i)] < arr[smallest]) {
            smallest = left(i);
        }
        if(right(i) < this.n && arr[right(i)] < arr[smallest]) {
            smallest = right(i);
        }

        if(smallest != i) {
            swap(this.arr, smallest, i);
            heapify(smallest);
        }
    }

    public void printHeap() {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    private int left(int i) {
        return 2*i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int searchKey(int key) {
        for (int i = 0; i < n; i++) {
            if(key == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

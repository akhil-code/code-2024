package datastructures.heaps;

public class HeapUtil {

    public static int left(int i) {
        return 2 * i + 1;
    }

    public static int right(int i) {
        return 2 * i + 2;
    }

    public static int parent(int i) {
        return (i - 1) / 2;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void minHeapify(int[] arr, int i) {
        int left = HeapUtil.left(i);
        int right = HeapUtil.right(i);

        int smallest = i;
        if(left < arr.length && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if(right < arr.length && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if(smallest != i) {
            HeapUtil.swap(arr, i, smallest);
            minHeapify(arr, smallest);
        }
    }

    public static void maxHeapify(int[] arr, int i) {
        int n = arr.length;
        int left = HeapUtil.left(i);
        int right = HeapUtil.right(i);

        int largest = i;
        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != i) {
            HeapUtil.swap(arr, i, largest);
            maxHeapify(arr, largest);
        }
    }
}

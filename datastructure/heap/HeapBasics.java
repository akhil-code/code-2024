package datastructure.heap;


public class HeapBasics {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(5);
        int[] arr = {6, 1, 3, 7, 2, 0};
        minHeap.createFromArray(arr);

        // getMin()
        System.out.println("getMin(): " + minHeap.getMin());

        // extractMin()
        System.out.println("extractMin(): " + minHeap.extractMin());
        System.out.println("extractMin(): " + minHeap.extractMin());
        System.out.println("extractMin(): " + minHeap.extractMin());

        minHeap.printHeap();
        minHeap.decreaseKey(7, 2);
        minHeap.decreaseKey(3, 1);
        minHeap.printHeap();


    }
}

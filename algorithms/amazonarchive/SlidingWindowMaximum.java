package algorithms.amazonarchive;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    // Driver's code
    public static void main(String args[])
    {
        int[] arr = { 1, 2, 3, 1, 4, 5};
        int K = 3;

        // Function call
        printKMax(arr, K);
    }

    private static void printKMax(int[] arr, int k) {
        int n = arr.length;
        final Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if(!deque.isEmpty() && i - k >= 0 && arr[i-k] == deque.getFirst()) {
                deque.removeFirst();
            }
            while(!deque.isEmpty() && arr[i] > deque.getLast()) {
                deque.removeLast();
            }
            deque.addLast(arr[i]);
            if(deque.size() > k) {
                deque.removeFirst();
            }

            if(i >= k - 1) {
                System.out.print(deque.getFirst() + ", ");
            }

        }



    }
}

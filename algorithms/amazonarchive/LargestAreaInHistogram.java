package algorithms.amazonarchive;

import java.util.Stack;

public class LargestAreaInHistogram {
    public static void main(String[] args) {
        int[] arr = {3,5,1,7,5,9};
        System.out.println(maxHistogramArea(arr));
    }

    public static int maxHistogramArea(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int maxArea = Integer.MIN_VALUE;
        while(i < n) {
            // pop all element greater than the current.
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int topIndex = stack.pop();
                int currArea = arr[topIndex] * (stack.isEmpty() ? i : (i - 1 - stack.peek()));
                maxArea = Math.max(currArea, maxArea);
            }
            stack.push(i);
            i++;
        }

        while(!stack.isEmpty()) {
            int topIndex = stack.pop();
            int currArea = arr[topIndex] * (stack.isEmpty() ? i : (i - 1 - stack.peek()));
            maxArea = Math.max(currArea, maxArea);
        }

        return maxArea;
    }
}

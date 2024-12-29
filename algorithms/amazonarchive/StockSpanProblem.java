package algorithms.amazonarchive;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] prices = {10, 4, 5, 90, 120, 80};
        stockSpan(prices);
    }

    private static void stockSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        span[0] = 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while(!stack.isEmpty() && prices[i] > prices[stack.peek()]) {
                stack.pop();
            }

            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        System.out.println(Arrays.toString(span));
    }
}

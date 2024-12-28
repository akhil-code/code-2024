package algorithms.array;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maximumProfit(prices));
    }

    // Working solution with continuous purchases.
    private static int maximumProfit(int[] prices) {
        // prices i+1 > prices i -> add profit & do nothing
        // prices i+1 == prices i -> do nothing
        // prices i+1 < prices i -> do not buy
        int n = prices.length;
        int totalProfit = 0;
        for (int i = 1; i < n; i++) {
            if(prices[i] > prices[i-1]) {
                totalProfit += (prices[i] - prices[i - 1]);
            }
        }

        return totalProfit;
    }


}

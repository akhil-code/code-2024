package algorithms.dynamicprogramming;

public class RodCutting {
    public static void main(String[] args) {

        int prices[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
        int n = prices.length;
        System.out.println("Maximum obtained value is " + cutRod(prices, 8));
    }

    public static int cutRod(int[] prices, int length) {
        int[] dp = new int[length + 1];
        dp[0] = 0;
        for (int i = 1; i <= length; i++) {
            dp[i] = 0;
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], prices[j-1] + dp[i-j]);
            }

        }

        return dp[length];
    }
}

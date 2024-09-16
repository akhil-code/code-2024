package algorithms.dynamicprogramming;

import java.util.Stack;

public class PrintAllSubsetsWithSum {
    public static void main(String[] args) {
        int arr[] = {2,3,5,6,8,10};
        int sum = 10;
        printSubsetSums(arr, sum);
    }

    public static void printSubsetSums(int[] arr, int sum) {
        int m = arr.length;
        boolean[][] dp = new boolean[m+1][sum+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if(j - arr[i-1] >= 0) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }

        // print all subset sums
        Stack<Integer> stack = new Stack<>();
        printSet(dp, arr, m, sum, stack);
    }

    private static void printSet(boolean[][] dp, int[] arr, int i, int j, Stack<Integer> stack) {
        if(j==0) {
            System.out.println(stack.toString());
            return;
        }
        // excluding
        if(i-1 >= 0 && dp[i-1][j]) {
            printSet(dp, arr, i-1, j, stack);
        }
        // including
        if(i-1 >= 0 && j-arr[i-1] >= 0 && dp[i-1][j-arr[i-1]]) {
            stack.add(arr[i-1]);
            printSet(dp, arr, i-1, j-arr[i-1], stack);
            stack.pop();
        }
    }
}

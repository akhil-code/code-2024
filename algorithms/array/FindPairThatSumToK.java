package algorithms.array;

import java.util.Arrays;

public class FindPairThatSumToK {

    public static void main(String[] args) {
        int[] arr = {19, 19, 30, 34, 41, 47, 62, 74, 91, 91};
        int targetSum = 64;

        System.out.println("input array: " + Arrays.toString(arr));
        Pair answer = findPairSum(arr, targetSum);
        if(answer != null) {
            System.out.println("Pair: " + answer.x + ", " + answer.y);
        } else {
            System.out.println("No matching pair found");
        }
    }


    private static Pair findPairSum(int[] arr, int targetSum) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;

        while(i < j) {
            int currSum = arr[i] + arr[j];
            if(targetSum > currSum) {
                i++;
            } else if(targetSum < currSum) {
                j--;
            } else {
                return new Pair(arr[i], arr[j]);
            }
        }
        return null;
    }

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}



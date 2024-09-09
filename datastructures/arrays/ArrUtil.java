package datastructures.arrays;

import java.util.Random;

public class ArrUtil {
    public static int[] createRandomArrayOfLength(int n, Integer minLimit, Integer maxLimit) {
        final Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(
                    minLimit != null ? minLimit : Integer.MIN_VALUE,
                    maxLimit != null ? maxLimit: Integer.MAX_VALUE);
        }
        return arr;
    }

    public static void print2DArray(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println("");
        }
    }
}

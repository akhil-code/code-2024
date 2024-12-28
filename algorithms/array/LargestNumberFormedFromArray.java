package algorithms.array;

import java.util.Arrays;

public class LargestNumberFormedFromArray {

    public static void main(String[] args) {
        Integer[] arr = { 3, 30, 34, 5, 9 };
        System.out.println(findLargest(arr));
    }

    public static int findLargest(Integer[] arr) {
        Arrays.sort(arr, (a, b) -> {
            int x = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
            int y = Integer.parseInt(String.valueOf(b) + String.valueOf(a));
            return y - x;
        });

        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            outputString.append(String.valueOf(arr[i]));
        }

        return Integer.parseInt(outputString.toString());
    }

}

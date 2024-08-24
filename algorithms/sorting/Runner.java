package algorithms.sorting;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        int[] inputArray = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(new BubbleSort().sort(inputArray)));
    }
}

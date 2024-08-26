package algorithms.sorting;

import algorithms.sorting.comparision.QuickSort;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        int[] inputArray = {23, 1, 10, 5, 2};
        System.out.println(Arrays.toString(new QuickSort().sort(inputArray)));
    }
}

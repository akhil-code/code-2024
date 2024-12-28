package algorithms.array;

import java.util.Arrays;

public class ConvertArrayToZigZag {
    public static void main(String[] args) {
        int arr[] = new int[] {1, 57, 9, 38, 48, 73, 22, 67, 41, 6};
        int[] answer = convertToZigZag(arr);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] convertToZigZag(int[] arr) {
        int n = arr.length;
        boolean lessThanCondition = false;
        for (int i = 1; i < n; i++) {
            if(lessThanCondition) {
                if(arr[i-1] > arr[i]) {
                    swap(arr, i, i-1);
                }
            } else {
                if(arr[i-1] < arr[i]) {
                    swap(arr, i, i-1);
                }
            }
            lessThanCondition = !lessThanCondition;
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

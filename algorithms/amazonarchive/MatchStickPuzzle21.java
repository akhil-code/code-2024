package algorithms.amazonarchive;

public class MatchStickPuzzle21 {
    // Driver code
    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 2};
        int N = arr.length;

        twentyoneMatchstick(arr, N);
    }

    private static void twentyoneMatchstick(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " : " + (5 - arr[i]));
        }
    }
}

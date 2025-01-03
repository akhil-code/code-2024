package algorithms.amazonarchive;

public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        System.out.println(search(arr, key, 0, arr.length - 1));
    }

    private static int search(int[] arr, int key, int l, int r) {
        if(l > r) {
            return -1;
        }

        int m = (l + r) / 2;
        if(arr[m] == key) {
            return m;
        }

        if(arr[l] <= arr[m] && key >= arr[l] && key <= arr[m]) {
            return search(arr, key, l, m - 1);
        } else if(arr[m] <= arr[r] && key >= arr[m] && key <= arr[r]) {
            return search(arr, key, m + 1, r);
        }

        if(arr[l] <= arr[m]) {
            return search(arr, key, m + 1, r);
        } else {
            return search(arr, key, l, m - 1);
        }
    }
}

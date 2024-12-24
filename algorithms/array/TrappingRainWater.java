package algorithms.array;

public class TrappingRainWater {
    // Driver code
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 3, 1, 0, 4 };
        System.out.println(maxWater(arr));
    }

    public static int maxWater(int[] arr) {
        int n = arr.length;
        int[] water = new int[n];
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = rightMax[n-1] = 0;

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i-1]);
        }

        for (int i = n-2; i >= 0 ; i--) {
            rightMax[i] = Math.max(arr[i+1], rightMax[i+1]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.max(0, Math.min(leftMax[i], rightMax[i]) - arr[i]);
        }
        return trappedWater;
    }
}

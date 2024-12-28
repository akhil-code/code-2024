package algorithms.amazonarchive;

public class ReachNumberWithTwoGivenLengths{
    public static void main (String[] args) {
        // Numbers to be checked for reachability
        int nums[] = { 9, 4 };
        int n = nums.length;

        // Starting number K
        int k = 8;
        // Sizes of jumps d1 and d2
        int d1 = 3, d2 = 2;

        reachTheNums(nums, k, d1, d2, n);
    }

    public static void reachTheNums(int[] nums, int k, int d1, int d2, int n) {
        int hcfOfDistances = hcf(d1, d2);
        for (int i = 0; i < n; i++) {
            if((nums[i] - k) % hcfOfDistances == 0) {
                System.out.print(nums[i] + ", ");
            }
        }
    }

    private static int hcf(int a, int b) {
        if(a == b) {
            return a;
        }

        if(a > b) {
            return hcf(a - b, b);
        } else {
            return hcf(a, b - a);
        }
    }
}

package algorithms.array;

import java.util.Random;

public class ArrayUtil {

    public static int[] createArrayOfSize(int n) {
        Random random = new Random();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = random.nextInt(100);
        }

        return ans;
    }
}

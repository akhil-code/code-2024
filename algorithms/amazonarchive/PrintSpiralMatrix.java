package algorithms.amazonarchive;

import java.util.LinkedList;
import java.util.List;

public class PrintSpiralMatrix {
    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        final List<Integer> res = spirallyTraverse(mat);

        for (int num : res) {
            System.out.print(num + " ");
        }
    }

    private static List<Integer> spirallyTraverse(int[][] mat) {
        List<Integer> ans = new LinkedList<>();
        int i = 0, j = -1;
        int n = mat.length;
        while(n > 0) {
            for (int k = 0; k < n; k++) {
                j++;
                ans.add(mat[i][j]);
            }

            for (int k = 0; k < n - 1; k++) {
                i++;
                ans.add(mat[i][j]);
            }

            for (int k = 0; k < n - 1; k++) {
                j--;
                ans.add(mat[i][j]);
            }

            for (int k = 0; k < n - 2; k++) {
                i--;
                ans.add(mat[i][j]);
            }

            n -= 2;
        }
        return ans;
    }
}

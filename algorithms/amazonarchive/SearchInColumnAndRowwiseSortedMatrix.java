package algorithms.amazonarchive;

public class SearchInColumnAndRowwiseSortedMatrix {

    public static void main(String[] args) {
        int[][] mat = {{3, 30, 38},
                        {20, 52, 54},
                        {35, 60, 69}};
        int x = 35;

        if(matSearch(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }

    private static boolean matSearch(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;
        int i = 0, j = n - 1;
        while(i < n && j >= 0) {
            if(target < mat[i][j]) {
                j--;
            } else if (target > mat[i][j]) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}

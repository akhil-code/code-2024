package algorithms.amazonarchive;

public class PrintPyramid {
    public static void main(String[] args) {
        printPyramid(5);
    }

    private static void printPyramid(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("1 ");
            }

            System.out.println("");
        }
    }
}

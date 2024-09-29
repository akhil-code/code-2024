package algorithms.dynamicprogramming;

public class PrintStringPermutations {
    public static void main(String[] args) {
        String s = "abcd";
        printPermutations(s, 0, s.length() - 1);
    }

    public static void printPermutations(String s, int i, int j) {
        if(i == j) {
            System.out.println(s);
            return;
        }

        for (int k = i; k <= j; k++) {
            s = swap(s, i, k);
            printPermutations(s, i + 1, j);
            s = swap(s, i, k);
        }
    }

    private static String swap(String s, int i1, int i2) {
        char c1 = s.charAt(i1);
        char c2 = s.charAt(i2);

        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.setCharAt(i1, c2);
        stringBuilder.setCharAt(i2, c1);
        return stringBuilder.toString();
    }

}

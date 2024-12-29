package algorithms.amazonarchive;

public class SwapTwoNumbersWithoutAdditionalElement {
    public static void main(String[] args) {
        int a = 5;
        int b = 10000;
        swap(a, b);
    }

    private static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + ", " + b);
    }

}

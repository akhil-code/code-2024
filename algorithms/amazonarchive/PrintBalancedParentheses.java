package algorithms.amazonarchive;

public class PrintBalancedParentheses {
    public static void main(String[] args) {
        int n = 2;
        printBalanced("", 0, n);
    }

    private static void printBalanced(String s, int diff, int n) {
        if(diff >= 0 && diff <= n && s.length() <= 2 * n) {
            if(s.length() == 2 * n && diff == 0) {
                System.out.println(s);
                return;
            }
            printBalanced(s + "(", diff + 1, n);
            printBalanced(s + ")", diff - 1, n);
        }
    }
}

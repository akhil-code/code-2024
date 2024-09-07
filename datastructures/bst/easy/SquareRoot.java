package datastructures.bst.easy;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(findSquareRoot(100));;
        System.out.println(findSquareRoot(200));;
        System.out.println(findSquareRoot(300));;
        System.out.println(findSquareRoot(400));;
        System.out.println(findSquareRoot(500));;
    }

    public static int findSquareRoot(int x) {
        int l = 0, r = x;
        int m = (l + r) / 2;
        while(l <  r) {
            m = (l+r) / 2;
            if(m * m == x) {
                return m;
            } else if (m * m < x) {
                l = m;
            } else {
                r = m;
            }
            if(r == l + 1) {
                break;
            }
        }
        return m;
    }
}

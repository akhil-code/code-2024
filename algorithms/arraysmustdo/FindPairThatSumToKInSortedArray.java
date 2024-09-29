package algorithms.arraysmustdo;

public class FindPairThatSumToKInSortedArray {

    public static void main(String[] args) {
        Pair result = findPairs(new int[]{1, 3, 5, 7, 8, 10, 15}, 15);
        if(result == null) {
            System.out.println("no pair");
        } else {
            System.out.println(result.p1 + ", " + result.p2);
        }
    }

    public static Pair findPairs(int[] arr, int k) {
        int n = arr.length;
        int startIndex = 0;
        int endIndex = n - 1;

        while(startIndex < endIndex) {
            int currSum = arr[startIndex] + arr[endIndex];
            if(currSum < k) {
                startIndex++;
            } else if(currSum > k) {
                endIndex--;
            } else {
                return new Pair(arr[startIndex], arr[endIndex]);
            }
        }
        System.out.println(startIndex + ", " + endIndex);
        return null;
    }

    static class Pair {
        int p1, p2;

        public Pair(int p1, int p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }
}

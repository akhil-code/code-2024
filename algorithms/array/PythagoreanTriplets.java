package algorithms.array;

import java.util.Arrays;

public class PythagoreanTriplets {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 6, 5};
        Triplet answer = findPythagoreanTriplet(arr);
        if (answer != null) {
            System.out.println("triplet: " + answer.a + ", " + answer.b + ", " + answer.c);
        } else {
            System.out.println("No pythagorean triplet found");
        }
    }

    public static Triplet findPythagoreanTriplet(int[] arr) {
        int n = arr.length;
        // clone
        int[] arrCopy = Arrays.copyOf(arr, n);
        // sort
        Arrays.sort(arrCopy);
        // square
        for (int i = 0; i < n; i++) {
            arrCopy[i] = arrCopy[i] * arrCopy[i];
        }

        int k = n - 1;

        while(k > 0) {
            int i = 0, j = k - 1;

            while(i < j) {
                int currSum = arrCopy[i] + arrCopy[j];
                if(currSum < arrCopy[k]) {
                    i++;
                } else if (currSum > arrCopy[k]) {
                    j--;
                } else {
                    return new Triplet(arrCopy[i], arrCopy[j], arrCopy[k]);
                }
            }
            k--;
        }
        return null;
    }

    public static class Triplet {
        int a, b, c;

        public Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}

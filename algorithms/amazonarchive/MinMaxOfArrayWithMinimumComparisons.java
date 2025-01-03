package algorithms.amazonarchive;

public class MinMaxOfArrayWithMinimumComparisons {
    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};

        Pair minmax = getMinMax(arr);
        System.out.printf("Minimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);

    }

    private static Pair getMinMax(int[] arr) {
        int minimum, maximum;
        if(arr[0] < arr[1]) {
            minimum = arr[0];
            maximum = arr[1];
        } else {
            minimum = arr[1];
            maximum = arr[0];
        }

        for (int i = 2; i < arr.length; i += 2) {
            if(i + 1 >= arr.length) {
                minimum = Math.min(minimum, arr[i]);
                maximum = Math.max(maximum, arr[i]);
                continue;
            }

            int localMinima, localMaxima;

            if(arr[i] < arr[i+1]) {
                localMinima = arr[i];
                localMaxima = arr[i + 1];
            } else {
                localMinima = arr[i + 1];
                localMaxima = arr[i];
            }

            minimum = Math.min(minimum, localMinima);
            maximum = Math.max(maximum, localMaxima);

        }

        return new Pair(minimum, maximum);
    }

    public static class Pair {
        int min, max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}

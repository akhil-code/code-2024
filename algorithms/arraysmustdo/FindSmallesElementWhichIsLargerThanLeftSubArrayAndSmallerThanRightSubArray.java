package algorithms.arraysmustdo;

import java.util.List;

public class FindSmallesElementWhichIsLargerThanLeftSubArrayAndSmallerThanRightSubArray {

    public int findElement(List<Integer> arr) {
        int n = arr.size();
        int[] smallestSoFar = new int[n];


        for(int i=n-1;i>=0;i--) {
            if(i == n-1)
                smallestSoFar[i] = 99999;
            else
                smallestSoFar[i] = arr.get(i + 1) < smallestSoFar[i+1] ? arr.get(i+1) : smallestSoFar[i+1];
        }

        int highestSoFar = -99999;
        for(int i=1;i<n-1;i++) {

            if(i > 0) {
                highestSoFar = arr.get(i-1) > highestSoFar ? arr.get(i-1) : highestSoFar;
            }


            if(arr.get(i) > highestSoFar && arr.get(i) < smallestSoFar[i]) {
                return arr.get(i);
            }
        }

        return -1;


    }
}

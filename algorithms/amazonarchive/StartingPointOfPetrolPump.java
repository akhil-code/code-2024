package algorithms.amazonarchive;

import java.util.Arrays;

public class StartingPointOfPetrolPump {
    public static void main(String[] args) {
        int[][] pumpInfo = {{6, 4}, {3, 6}, {7, 3}};
        int start = startPointOfTour(pumpInfo);
        System.out.println(start == -1 ? "No Solution" : "Start = " + start);
    }

    private static int startPointOfTour(int[][] pumpInfo) {
        int n = pumpInfo.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = pumpInfo[i][0] - pumpInfo[i][1];
        }

        System.out.println(Arrays.toString(diff));

        int start = 0, end = 0;
        int currDiff = diff[start];
        int visited = 1;

        while(visited < n) {
            if(currDiff < 0) {
                if(start == end) {
                    start++;
                    end++;
                    currDiff = diff[start];
                    visited = 1;
                } else {
                    currDiff -= diff[start];
                    start++;
                    visited--;
                }
            } else {
                end = (end + 1) % n;
                currDiff += diff[end];
                visited++;
            }
        }
        return start;
    }
}

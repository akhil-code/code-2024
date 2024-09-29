package algorithms.arraysmustdo;

import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistributionProblem {
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        long minDifference = 99999;
        for(int i=0;i<n;i++) {
            int j = i + m - 1;

            if(j < n && a.get(j) - a.get(i) < minDifference) {
                minDifference = a.get(j) - a.get(i);
            }
        }

        return minDifference;
    }
}

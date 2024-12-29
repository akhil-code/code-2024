package algorithms.amazonarchive;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadderMinDiceThrows {
    public static void main(String[] args) {
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is "
                + getMinDiceThrows(moves, N));
    }

    private static int getMinDiceThrows(int[] moves, int N) {
        int[] dist = new int[N];
        dist[0] = 0;
        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);

        for (int i = 1; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;
            // iterate through neighbours  : curr + 1 to curr + 6;
            for (int i = 1; i <= 6; i++) {
                int next = curr + i;
                if(next >= N) {
                    break;
                }
                if(moves[i] != -1) {
                    next = moves[i];
                }
                dist[next] = Math.min(dist[next], 1 + dist[curr]);
                if(!visited[next]) {
                    queue.add(next);
                }
            }
        }

        return dist[N - 1];
    }
}

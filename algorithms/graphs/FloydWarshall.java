package algorithms.graphs;

public class FloydWarshall {
    public static void main(String[] args)
    {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
        final int INF = Integer.MAX_VALUE;
        int graph[][] = { { 0, 5, INF, 10 },
                        { INF, 0, 3, INF },
                        { INF, INF, 0, 1 },
                        { INF, INF, INF, 0 } };
        floydWarshall(graph);
    }

    public static void floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] shortestDist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                shortestDist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(shortestDist[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE &&
                            shortestDist[i][k] + graph[k][j] < shortestDist[i][j]) {
                        shortestDist[i][j] = shortestDist[i][k] + graph[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(shortestDist[i][j] == Integer.MAX_VALUE ? "INF, " : shortestDist[i][j] + ", ");
            }
            System.out.println("");
        }
    }
}

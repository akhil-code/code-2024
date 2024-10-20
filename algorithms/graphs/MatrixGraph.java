package algorithms.graphs;

public class MatrixGraph {
    int n;
    boolean[][] map;

    public MatrixGraph(int n) {
        this.n = n;
        this.map = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.map[i][j] = false;
            }
        }

    }

    public void addEdge(int src, int dest) {
        this.map[src][dest] = true;
    }

    public void printGraph() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < n; j++) {
                System.out.print((this.map[i][j] ? 1 : 0 )+ ", ");
            }
            System.out.println("");
        }
    }
}

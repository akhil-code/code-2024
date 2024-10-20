package algorithms.graphs;

public class GraphEdge {
    int src;
    int dest;
    int weight;

    public GraphEdge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public GraphEdge(int src, int dest) {
        this.src = src;
        this.dest = dest;
        this.weight = 1;
    }
}

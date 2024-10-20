package algorithms.graphs;

public class GraphNode {
    int nodeId;
    int dist;

    public GraphNode(int nodeId, int dist) {
        this.nodeId = nodeId;
        this.dist = dist;
    }

    public GraphNode(int nodeId) {
        this.nodeId = nodeId;
        this.dist = 1;
    }
}

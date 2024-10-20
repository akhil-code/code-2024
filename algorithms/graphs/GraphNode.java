package algorithms.graphs;

public class GraphNode {
    int nodeId;
    int weight;

    public GraphNode(int nodeId, int weight) {
        this.nodeId = nodeId;
        this.weight = weight;
    }

    public GraphNode(int nodeId) {
        this.nodeId = nodeId;
        this.weight = 1;
    }
}

package algorithms.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    int size;
    List<List<GraphNode>> nodes;

    public Graph(int size) {
        this.size = size;
        nodes = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            nodes.add(new LinkedList<>());
        }
    }

    public void addEdge(int src, int dest) {
        this.nodes.get(src).add(new GraphNode(dest));
    }

    public void addWeightedEdge(int src, int dest, int weight) {
        this.nodes.get(src).add(new GraphNode(dest, weight));
    }

    public void printGraph() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            List<GraphNode> adjNodes = this.nodes.get(i);
            for(GraphNode adjNode : adjNodes) {
                System.out.print(adjNode + ", ");
            }
            System.out.println("");
        }
    }

    public List<GraphEdge> getAllEdges() {
        List<GraphEdge> edges = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<GraphNode> adjNodes = nodes.get(i);
            for(GraphNode adjNode : adjNodes) {
                edges.add(new GraphEdge(i, adjNode.nodeId, adjNode.weight));
            }
        }
        return edges;
    }
}

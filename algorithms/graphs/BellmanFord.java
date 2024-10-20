package algorithms.graphs;

import java.util.Arrays;
import java.util.List;

public class BellmanFord {

    // Driver's code
    public static void main(String[] args)
    {
        int V = 5; // Number of vertices in graph

        Graph graph = new Graph(V);

        graph.addWeightedEdge(0, 1, -1);
        graph.addWeightedEdge(0, 2, 4);
        graph.addWeightedEdge(1,2,3);
        graph.addWeightedEdge(1,3,2);
        graph.addWeightedEdge(1,4,2);
        graph.addWeightedEdge(3,2,5);
        graph.addWeightedEdge(3,1,1);
        graph.addWeightedEdge(4,3,-3);

        bellmanFord(graph, 0);

    }

    public static void bellmanFord(Graph g, int startNode) {
        int[] dist = new int[g.size];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;
        List<GraphEdge> edges = g.getAllEdges();
        for (int i = 0; i < g.size - 1; i++) {
            for(GraphEdge edge : edges) {
                if(dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                    dist[edge.dest] = dist[edge.src] + edge.weight;
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }
}

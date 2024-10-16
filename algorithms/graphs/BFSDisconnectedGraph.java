package algorithms.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSDisconnectedGraph {
    public static void main(String[] args) {
        int V = 6; // Number of vertices
        List<List<Integer>> adj = new ArrayList<>(V);

        // Initialize adjacency lists
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);

        // Perform BFS traversal for the entire graph
        bfsDisconnected(adj);
    }

    private static void addEdge(List<List<Integer>> graph, int src, int dest) {
        graph.get(src).add(dest);
    }

    private static void bfsUtil(List<List<Integer>> graph, int src, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            if(!visited[currNode]) {
                visited[currNode] = true;
                System.out.print(currNode + ", ");
                List<Integer> adjNodes = graph.get(currNode);
                for (int i = 0; i < adjNodes.size(); i++) {
                    int nextNode = adjNodes.get(i);
                    if(!visited[nextNode]) {
                        queue.add(nextNode);
                    }
                }
            }
        }
    }

    private static void bfsDisconnected(List<List<Integer>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfsUtil(graph, i, visited);
            }
        }
    }

}

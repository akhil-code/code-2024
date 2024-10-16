package algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String[] args)
    {
        int V = 5; // Number of vertices in the graph

        // Create an adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Define the edges of the graph
        int[][] edges = {
                { 1, 2 }, { 1, 0 }, { 2, 0 }, { 2, 3 }, { 2, 4 }
        };

        // Populate the adjacency list with edges
        for (int[] e : edges) {
            addEdge(adj, e[0], e[1]);
        }

        int source = 1;
        System.out.println("DFS from source: " + source);
        DFS(adj, new boolean[V], source);
    }

    private static void addEdge(List<List<Integer>> adj, int src, int dest) {
        adj.get(src).add(dest);
    }

    private static void DFS(List<List<Integer>> graph, boolean[] visited, int src) {
        if(!visited[src]) {
            visited[src] = true;
            System.out.print(src + ", ");
            for(int nextNode : graph.get(src)) {
                if(!visited[nextNode]) {
                    DFS(graph, visited, nextNode);
                }
            }
        }
    }

    private static void DFSDisconnected(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if(!visited[i]) {
                DFS(graph, visited, i);
            }
        }
    }
}

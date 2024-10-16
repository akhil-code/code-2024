package algorithms.graphs;

import java.util.*;

public class BFSConnectedGraph {

    public static void main(String[] args) {

        // Number of vertices in the graph
        int V = 5;

        // Adjacency list representation of the graph
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 4);

        // Perform BFS traversal starting from vertex 0
        System.out.println("BFS starting from 0:");
        bfs(adj, 0);
    }

    private static void addEdge(List<List<Integer>> adj, int src, int dest) {
        adj.get(src).add(dest);
    }

    private static void bfs(List<List<Integer>> adj, int source) {
        Queue<Integer> queue = new LinkedList<>();
        int n = adj.size();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        queue.add(source);
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            if(!visited[currNode]) {
                System.out.print(currNode + ", ");
                visited[currNode] = true;
                List<Integer> adjNodes = adj.get(currNode);
                for (int i = 0; i < adjNodes.size(); i++) {
                    int nextNode = adjNodes.get(i);
                    if(!visited[nextNode]) {
                        queue.add(nextNode);
                    }
                }
            }
        }

    }
}

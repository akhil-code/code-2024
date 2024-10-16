package algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CycleInDirectedGraph {
    // Driver function
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(3);

        // Function call
        if (isCyclic(adj)) {
            System.out.println("Contains cycle");
        } else {
            System.out.println("No Cycle");
        }
    }

    private static void addEdge(List<List<Integer>> graph, int src, int dest) {
        graph.get(src).add(dest);
    }

    private static boolean isCyclic(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        boolean[] recStack = new boolean[graph.size()];
        Arrays.fill(visited, false);
        Arrays.fill(recStack, false);

        for (int i = 0; i < graph.size(); i++) {
            if(isCyclicUtil(graph, i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclicUtil(List<List<Integer>> graph, int currNode, boolean[] visited, boolean[] recStack) {
        if(!visited[currNode]) {
            recStack[currNode] = true;
            visited[currNode] = true;

            for(int nextNode : graph.get(currNode)) {
                if(!visited[nextNode] && isCyclicUtil(graph, nextNode, visited, recStack)) {
                    return true;
                } else if(recStack[nextNode]) {
                    return true;
                }
            }
            recStack[currNode] = false;
        }
        return false;
    }
}

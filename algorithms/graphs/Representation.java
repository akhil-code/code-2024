package algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Representation {
    public static void main(String[] args) {
        // matrix representation
        int[][] matrixRepresentation = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        // adjacency list
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);

        printGraph(adj);

    }

    private static void addEdge(List<List<Integer>> graph, int src, int dest) {
        graph.get(src).add(dest);
    }


    private static void printGraph(List<List<Integer>> adj) {
        int n = adj.size();
        for (int i = 0; i < n; i++) {
            List<Integer> adjNodes = adj.get(i);
            System.out.print(i + " : ");
            for (int j = 0; j < adjNodes.size(); j++) {
                System.out.print(adjNodes.get(j) + ", ");
            }
            System.out.println("");
        }
    }
}

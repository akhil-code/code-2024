package algorithms.graphs;

import java.util.Arrays;
import java.util.Stack;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        Graph g = new Graph(3);

        g.addEdge(1, 0);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 1);

        System.out.println(isCyclic(g) ? "Contains cycle" : "No Cycle");

        Graph g2 = new Graph(3);

        g2.addEdge(1, 0);
        g2.addEdge(0, 1);

        g2.addEdge(1, 2);
        g2.addEdge(2, 1);

        System.out.println(isCyclic(g2) ? "Contains Cycle" : "No Cycle");
    }

    private static boolean isCyclicUtil(Graph g, boolean[] visited, boolean[] recStack,  int curr, int parent) {
        if(!visited[curr]) {
            visited[curr] = true;
            recStack[curr] = true;

            for(GraphNode adjNode : g.nodes.get(curr)) {
                if(!visited[adjNode.nodeId] && isCyclicUtil(g, visited, recStack, adjNode.nodeId, curr)) {
                    return true;
                } else if(recStack[adjNode.nodeId] && adjNode.nodeId != parent) {
                    return true;
                }
            }
            recStack[curr] = false;
        }
        return false;
    }

    public static boolean isCyclic(Graph g) {
        boolean[] visited = new boolean[g.size];
        boolean[] recStack = new boolean[g.size];
        Arrays.fill(visited, false);
        Arrays.fill(recStack, false);
        for (int i = 0; i < g.size; i++) {
            if(!visited[i] && isCyclicUtil(g, visited, recStack, i, -1)) {
                return true;
            }
        }
        return false;
    }
}

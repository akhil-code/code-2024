package algorithms.graphs;

import java.util.List;

public class CycleDetectionDirectedGraph {
    // Driver function
    public static void main(String[] args) {
        Graph g = new Graph(4);
        // Adding edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        // Function call to check for cycles
        if (isCyclic(g)) {
            System.out.println("Contains cycle");
        } else {
            System.out.println("No Cycle");
        }
    }

    public static boolean isCyclic(Graph g) {
        boolean[] visited = new boolean[g.size];
        boolean[] recStack = new boolean[g.size];

        for (int i = 0; i < g.size; i++) {
            if(!visited[i]) {
                if(isCyclic(g, i, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCyclic(Graph g, int curr, boolean[] visited, boolean[] recStack) {
        if(!visited[curr]) {
            visited[curr] = true;
            recStack[curr] = true;
            final List<GraphNode> adjNodes = g.nodes.get(curr);
            for(GraphNode adjNode : adjNodes) {
                if(!visited[adjNode.nodeId] && isCyclic(g, adjNode.nodeId, visited, recStack)) {
                    return true;
                } else if(recStack[adjNode.nodeId]) {
                    return true;
                }
            }
        }
        recStack[curr] = false;
        return false;
    }
}

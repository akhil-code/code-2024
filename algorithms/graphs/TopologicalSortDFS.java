package algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopologicalSortDFS {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1,2);
        g.addEdge(3, 1);
        g.addEdge(3, 2);
        List<Integer> output = topologicalSort(g);
        System.out.println(output.toString());
    }

    public static List<Integer> topologicalSort(Graph g) {
        List<Integer> output = new ArrayList<>();
        boolean[] visited = new boolean[g.size];
        Arrays.fill(visited, false);
        for (int i = 0; i < g.size; i++) {
            dfsUtil(g, i, visited, output);
        }
        return output;
    }

    public static void dfsUtil(Graph g, int curr, boolean[] visited, List<Integer> output) {
        if(!visited[curr]) {
            visited[curr] = true;
            for(GraphNode adjNode : g.nodes.get(curr)) {
                dfsUtil(g, adjNode.nodeId, visited, output);
            }
            output.add(0, curr);
        }
    }
}

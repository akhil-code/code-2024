package algorithms.graphs;

import java.util.List;

public class DFSGraph {
    public static void main(String[] args){
        Graph g = new Graph(6);

        int[][] edges
                = { { 1, 2 }, { 2, 0 }, { 0, 3 }, { 4, 5 } };

        for (int[] edge : edges) {
            g.addEdge(edge[0], edge[1]);
        }

        System.out.println("Complete DFS of the graph:");
        dfsDisconnected(g);
    }

    public static void dfsDisconnected(Graph g) {
        boolean[] visited = new boolean[g.size];
        for (int i = 0; i < g.size; i++) {
            if(!visited[i]) {
                dfs(g, i, visited);
            }
        }
    }

    public static void dfs(Graph g, int curr, boolean[] visited) {
        if(!visited[curr]) {
            visited[curr] = true;
            System.out.println(curr);
            List<GraphNode> adjNodes = g.nodes.get(curr);
            for(GraphNode adjNode : adjNodes) {
                if(!visited[adjNode.nodeId]) {
                    dfs(g, adjNode.nodeId, visited);
                }
            }
        }
    }

}

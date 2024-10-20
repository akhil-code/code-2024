package algorithms.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {
    public static void main(String[] args) {
        Graph g = new Graph(6);

        // Add edges to the graph
        g.addEdge(0, 1);
        g.addEdge( 0, 2);
        g.addEdge( 3, 4);
        g.addEdge( 4, 5);

        // Perform BFS traversal for the entire graph
        bfsDisconnected(g);
    }

    public static void bfsDisconnected(Graph g) {

        boolean[] visited = new boolean[g.size];
        Arrays.fill(visited, false);

        for (int i = 0; i < g.size; i++) {
            if(!visited[i]) {
                bfs(g, i, visited);
            }
        }
    }

    public static void bfs(Graph g, int src, boolean[] visited) {
        Queue<Integer> queue =  new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            System.out.println(currNode);
            visited[currNode] = true;
            List<GraphNode> adjNodes = g.nodes.get(currNode);
            for(GraphNode adjNode : adjNodes) {
                if(!visited[adjNode.nodeId]) {
                    queue.add(adjNode.nodeId);
                }
            }
        }
    }
}

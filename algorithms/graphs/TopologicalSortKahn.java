package algorithms.graphs;

import java.util.*;

public class TopologicalSortKahn {
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
        int[] indegree = new int[g.size];
        Arrays.fill(indegree, 0);

        for(List<GraphNode> adjNodes : g.nodes) {
            for(GraphNode adjNode : adjNodes) {
                indegree[adjNode.nodeId]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < g.size; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            output.add(curr);
            for(GraphNode adjNode : g.nodes.get(curr)) {
                indegree[adjNode.nodeId]--;
                if(indegree[adjNode.nodeId] == 0) {
                    queue.add(adjNode.nodeId);
                }
            }
        }

        return output;
    }
}

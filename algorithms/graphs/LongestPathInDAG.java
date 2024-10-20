package algorithms.graphs;

import java.util.*;

public class LongestPathInDAG {
    // Driver program to test above functions  
    public static void main(String args[])
    {
        Graph g = new Graph(6);
        g.addWeightedEdge(0, 1, 5);
        g.addWeightedEdge(0, 2, 3);
        g.addWeightedEdge(1, 3, 6);
        g.addWeightedEdge(1, 2, 2);
        g.addWeightedEdge(2, 4, 4);
        g.addWeightedEdge(2, 5, 2);
        g.addWeightedEdge(2, 3, 7);
        g.addWeightedEdge(3, 5, 1);
        g.addWeightedEdge(3, 4, -1);
        g.addWeightedEdge(4, 5, -2);

        int s = 1;
        System.out.print("Following are longest distances from source vertex "+ s + " \n" );
        findLongestPath(g, s);

    }

    public static void findLongestPath(Graph g, int start) {
        int[] dist = new int[g.size];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[start] = 0;
        // find topological sort
        List<Integer> sortedNodes = topologicalSort(g);
        for (int i = 0; i < sortedNodes.size(); i++) {
            int curNode = sortedNodes.get(i);
            for(GraphNode adjNode : g.nodes.get(sortedNodes.get(i))) {
                if(dist[curNode] != Integer.MIN_VALUE &&
                        dist[curNode] + adjNode.weight > dist[adjNode.nodeId]) {
                    dist[adjNode.nodeId] = dist[curNode] + adjNode.weight;
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }

    private static List<Integer> topologicalSort(Graph g) {
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

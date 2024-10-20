package algorithms.graphs;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraShortestPath {

    public static void main(String[] args) {
        final Graph g = new Graph(9);

        g.addWeightedEdge(0, 1, 4);
        g.addWeightedEdge(0, 7, 8);
        g.addWeightedEdge(1, 2, 8);
        g.addWeightedEdge(1, 7, 11);
        g.addWeightedEdge(2, 3, 7);
        g.addWeightedEdge(2, 8, 2);
        g.addWeightedEdge(2, 5, 4);
        g.addWeightedEdge(3, 4, 9);
        g.addWeightedEdge(3, 5, 14);
        g.addWeightedEdge(4, 5, 10);
        g.addWeightedEdge(5, 6, 2);
        g.addWeightedEdge(5, 4, 10);
        g.addWeightedEdge(6, 7, 1);
        g.addWeightedEdge(6, 5, 2);
        g.addWeightedEdge(6, 8, 6);
        g.addWeightedEdge(7, 8, 7);
        g.addWeightedEdge(7, 6, 1);

        shortestPath(g, 0);
        shortestPathPriorityQueue(g, 0);
    }

    public static void shortestPath(Graph graph, int start) {
        int n = graph.size;
        int[] dist = new int[n];
        boolean[] sptSet = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(sptSet, false);
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            int minNode = getMinNode(dist, sptSet);
            sptSet[minNode] = true;
            for(GraphNode adjNode : graph.nodes.get(minNode)) {
                if(dist[minNode] + adjNode.weight < dist[adjNode.nodeId]) {
                    dist[adjNode.nodeId] = dist[minNode] + adjNode.weight;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + dist[i]);
        }
    }

    public static void shortestPathPriorityQueue(Graph graph, int start) {
        int n = graph.size;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<MinDistNode> pq = new PriorityQueue<>((node1, node2) -> {
            return node1.dist - node2.dist;
        });

        pq.add(new MinDistNode(start, 0));

        while(!pq.isEmpty()) {
            MinDistNode minDistNode = pq.poll();
            List<GraphNode> adjNodes = graph.nodes.get(minDistNode.node);
            for(GraphNode adjNode : adjNodes) {
                if(dist[minDistNode.node] + adjNode.weight < dist[adjNode.nodeId]) {
                    dist[adjNode.nodeId] = dist[minDistNode.node] + adjNode.weight;
                    System.out.println("setting " + adjNode.nodeId + ": " + dist[adjNode.nodeId]);
                }
                pq.add(new MinDistNode(adjNode.nodeId, dist[adjNode.nodeId]));
            }
        }

        System.out.println(Arrays.toString(dist));
    }


    private static int getMinNode(int[] dist, boolean[] sptSet) {
        int n = dist.length;
        int minNode = -1;
        for (int i = 0; i < n; i++) {
            if(!sptSet[i]) {
                if(minNode == -1) {
                    minNode = i;
                } else if(dist[i] < dist[minNode]){
                    minNode = i;
                }
            }
        }
        return minNode;
    }

    public static class MinDistNode{
        int node;
        int dist;

        public MinDistNode(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

}

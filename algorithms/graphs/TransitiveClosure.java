package algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransitiveClosure {

    // Driver Code
    public static void main(String[] args) {

        // Create a graph given
        // in the above diagram
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Transitive closure " +
                "matrix is");

        g.transitiveClosure();

    }

    static class Graph {
        int n;
        List<List<Integer>> nodes;

        public Graph(int n) {
            this.n = n;
            nodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nodes.add(new ArrayList<>());
            }
        }

        public void addEdge(int src, int dest) {
            nodes.get(src).add(dest);
        }

        public void transitiveClosure() {
            boolean[][] closureMatrix = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                dfs(i, closureMatrix);
            }

            for (int i = 0; i < closureMatrix.length; i++) {
                System.out.println(Arrays.toString(closureMatrix[i]));
            }

        }

        private void dfs(int startNode, boolean[][] closureMatrix) {
            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);
            dfs(startNode, startNode, closureMatrix, visited);
        }

        private void dfs(int startNode, int currNode, boolean[][] closureMatrix, boolean[] visited) {
            if(!visited[currNode]) {
                visited[currNode] = true;
                for(int nextNode : nodes.get(currNode)) {
                    closureMatrix[startNode][nextNode] = true;
                    dfs(startNode, nextNode, closureMatrix, visited);
                }
            }
        }
    }
}

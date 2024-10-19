package algorithms.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    int size;
    List<List<Integer>> nodes;

    public Graph(int size) {
        this.size = size;
        this.nodes = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            this.nodes.add(new LinkedList<>());
        }
    }

    public void addEdge(int src, int dest) {
        this.nodes.get(src).add(dest);
    }

    public boolean isEdgePresent(int src, int dest) {
        if(!this.nodes.get(src).isEmpty()) {
            List<Integer> adjNodes = this.nodes.get(src);
            for(int adjNode : adjNodes) {
                if(adjNode == dest) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printGraph() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            List<Integer> adjNodes = this.nodes.get(i);
            for(int adjNode : adjNodes) {
                System.out.print(adjNode + ", ");
            }
            System.out.println("");
        }
    }
}

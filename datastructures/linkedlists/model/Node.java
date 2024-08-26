package datastructures.linkedlists.model;

public class Node {
    public int data;
    public Node nextNode;

    public Node(int data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public Node(int data) {
        this.data = data;
        this.nextNode = null;
    }
}

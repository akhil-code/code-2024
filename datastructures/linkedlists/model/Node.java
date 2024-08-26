package datastructures.linkedlists.model;

public class Node {
    public int data;
    public Node nextNode;
    public Node prevNode;

    public Node(int data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
        this.prevNode = null;
    }

    public Node(int data) {
        this.data = data;
        this.nextNode = null;
        this.prevNode = null;
    }
}

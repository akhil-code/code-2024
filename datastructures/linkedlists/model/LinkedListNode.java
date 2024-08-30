package datastructures.linkedlists.model;

public class LinkedListNode {
    public int data;
    public LinkedListNode nextNode;
    public LinkedListNode prevNode;

    public LinkedListNode(int data, LinkedListNode nextNode) {
        this.data = data;
        this.nextNode = nextNode;
        this.prevNode = null;
    }

    public LinkedListNode(int data) {
        this.data = data;
        this.nextNode = null;
        this.prevNode = null;
    }
}

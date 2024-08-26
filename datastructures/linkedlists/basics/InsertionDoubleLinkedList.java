package datastructures.linkedlists.basics;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.model.LinkedListUtil;

public class InsertionDoubleLinkedList {
    public static void main(String[] args) {
        System.out.println("Creating double linked list");
        Node doubleLinkedList = createDummyDoubleLinkedList();
        addAtPositionInDoubleLinkedList(doubleLinkedList, 2, 999);
        LinkedListUtil.printLinkedList(doubleLinkedList);
        addAtPositionInDoubleLinkedList(doubleLinkedList, 0, -1);
        LinkedListUtil.printLinkedList(doubleLinkedList);
    }

    private static Node createDummyDoubleLinkedList() {
        Node linkedList = new Node(0);
        Node node1 = new Node(1);
        linkedList.nextNode = node1;
        node1.prevNode = linkedList;

        Node node2 = new Node(2);
        node1.nextNode = node2;
        node2.prevNode = node1;

        Node node3 = new Node(3);
        node2.nextNode = node3;
        node3.prevNode = node2;

        return linkedList;
    }


    /**
     * Double linked list
     * Add node with data at pth position
     */
    public static void addAtPositionInDoubleLinkedList(Node head, int pos, int data) {
        if(pos == 0) {
            Node newNode = new Node(head.data);
            head.data = data;
            newNode.nextNode = head.nextNode;
            newNode.prevNode = head;
            head.nextNode.prevNode = newNode;
            head.nextNode = newNode;
            return;
        }

        int i  = 0;
        Node currNode = head;
        while(i < pos - 1 && currNode != null) {
            currNode = currNode.nextNode;
            i++;
        }
        Node newNode = new Node(data);
        newNode.nextNode = currNode.nextNode;
        newNode.prevNode = currNode;
        if(currNode.nextNode != null) {
            currNode.nextNode.prevNode = newNode;
        }
        currNode.nextNode = newNode;
    }
}

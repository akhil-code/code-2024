package datastructures.linkedlists.util;

import datastructures.linkedlists.model.Node;

public class LinkedListUtil {

    public static void printLinkedList(Node head) {
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.nextNode;
        }
        System.out.println("null");
    }

    public static Node createDummyLinkedList() {
        Node linkedList1 = new Node(0);
        linkedList1.nextNode = new Node(1);
        linkedList1.nextNode.nextNode = new Node(2);
        linkedList1.nextNode.nextNode.nextNode = new Node(3);
        linkedList1.nextNode.nextNode.nextNode.nextNode = new Node(4);
        linkedList1.nextNode.nextNode.nextNode.nextNode.nextNode = new Node(5);
        linkedList1.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode = new Node(6);
        return linkedList1;
    }

    public static Node createDummyDoubleLinkedList() {
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
}

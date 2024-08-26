package datastructures.linkedlists.basics;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

public class Insertion {

    public static void main(String[] args) {
        Node linkedList1 = LinkedListUtil.createDummyLinkedList();
        linkedList1 = insertAtStart(linkedList1, -1);
        linkedList1 = insertAtEnd(linkedList1, 25);
        linkedList1 = insertAtIndex(linkedList1, 2, 999);
        LinkedListUtil.printLinkedList(linkedList1);
    }

    public static Node insertAtStart(Node head, int data) {
        Node newNode = new Node(data);
        newNode.nextNode = head;
        return newNode;
    }

    public static Node insertAtEnd(Node head, int data) {

        if(head == null) {
            return new Node(data);
        }

        Node currNode = head;
        while(currNode.nextNode != null) {
            currNode = currNode.nextNode;
        }
        currNode.nextNode = new Node(data);
        return head;
    }

    public static Node insertAtIndex(Node head, int index, int data) {
        if (index == 0) {
            return new Node(data);
        }

        int i = 0;
        Node currNode = head;
        while(i < index-1 && currNode != null) {
            currNode = currNode.nextNode;
            i++;
        }

        Node newNode = new Node(data);
        newNode.nextNode = currNode.nextNode;
        currNode.nextNode = newNode;
        return head;
    }
}

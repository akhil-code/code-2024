package datastructures.linkedlists.basics;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

public class InsertionDoubleLinkedList {
    public static void main(String[] args) {
        System.out.println("Creating double linked list");
        Node doubleLinkedList = LinkedListUtil.createDummyDoubleLinkedList();
        addAtPositionInDoubleLinkedList(doubleLinkedList, 2, 999);
        LinkedListUtil.printLinkedList(doubleLinkedList);
        addAtPositionInDoubleLinkedList(doubleLinkedList, 0, -1);
        LinkedListUtil.printLinkedList(doubleLinkedList);
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

package datastructures.linkedlists.basics;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

public class InsertionDoubleLinkedList {
    public static void main(String[] args) {
        System.out.println("Creating double linked list");
        LinkedListNode doubleLinkedList = LinkedListUtil.createDummyDoubleLinkedList();
        addAtPositionInDoubleLinkedList(doubleLinkedList, 2, 999);
        LinkedListUtil.printLinkedList(doubleLinkedList);
        addAtPositionInDoubleLinkedList(doubleLinkedList, 0, -1);
        LinkedListUtil.printLinkedList(doubleLinkedList);
    }

    /**
     * Double linked list
     * Add node with data at pth position
     */
    public static void addAtPositionInDoubleLinkedList(LinkedListNode head, int pos, int data) {
        if(pos == 0) {
            LinkedListNode newNode = new LinkedListNode(head.data);
            head.data = data;
            newNode.nextNode = head.nextNode;
            newNode.prevNode = head;
            head.nextNode.prevNode = newNode;
            head.nextNode = newNode;
            return;
        }

        int i  = 0;
        LinkedListNode currNode = head;
        while(i < pos - 1 && currNode != null) {
            currNode = currNode.nextNode;
            i++;
        }
        LinkedListNode newNode = new LinkedListNode(data);
        newNode.nextNode = currNode.nextNode;
        newNode.prevNode = currNode;
        if(currNode.nextNode != null) {
            currNode.nextNode.prevNode = newNode;
        }
        currNode.nextNode = newNode;
    }
}

package datastructures.linkedlists.basics;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

public class Insertion {

    public static void main(String[] args) {
        LinkedListNode linkedList1 = LinkedListUtil.createDummyLinkedList();
        linkedList1 = insertAtStart(linkedList1, -1);
        linkedList1 = insertAtEnd(linkedList1, 25);
        linkedList1 = insertAtIndex(linkedList1, 2, 999);
        LinkedListUtil.printLinkedList(linkedList1);
    }

    public static LinkedListNode insertAtStart(LinkedListNode head, int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        newNode.nextNode = head;
        return newNode;
    }

    public static LinkedListNode insertAtEnd(LinkedListNode head, int data) {

        if(head == null) {
            return new LinkedListNode(data);
        }

        LinkedListNode currNode = head;
        while(currNode.nextNode != null) {
            currNode = currNode.nextNode;
        }
        currNode.nextNode = new LinkedListNode(data);
        return head;
    }

    public static LinkedListNode insertAtIndex(LinkedListNode head, int index, int data) {
        if (index == 0) {
            return new LinkedListNode(data);
        }

        int i = 0;
        LinkedListNode currNode = head;
        while(i < index-1 && currNode != null) {
            currNode = currNode.nextNode;
            i++;
        }

        LinkedListNode newNode = new LinkedListNode(data);
        newNode.nextNode = currNode.nextNode;
        currNode.nextNode = newNode;
        return head;
    }
}

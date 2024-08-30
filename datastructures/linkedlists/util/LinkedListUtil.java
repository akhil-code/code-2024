package datastructures.linkedlists.util;

import datastructures.linkedlists.model.LinkedListNode;

import java.util.List;

public class LinkedListUtil {

    public static void printLinkedList(LinkedListNode head) {
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.nextNode;
        }
        System.out.println("null");
    }

    public static LinkedListNode createDummyLinkedList() {
        LinkedListNode linkedList1 = new LinkedListNode(0);
        linkedList1.nextNode = new LinkedListNode(1);
        linkedList1.nextNode.nextNode = new LinkedListNode(2);
        linkedList1.nextNode.nextNode.nextNode = new LinkedListNode(3);
        linkedList1.nextNode.nextNode.nextNode.nextNode = new LinkedListNode(4);
        linkedList1.nextNode.nextNode.nextNode.nextNode.nextNode = new LinkedListNode(5);
        linkedList1.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode = new LinkedListNode(6);
        linkedList1.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode = new LinkedListNode(7);
        return linkedList1;
    }

    public static LinkedListNode createDummyDoubleLinkedList() {
        LinkedListNode linkedList = new LinkedListNode(0);
        LinkedListNode node1 = new LinkedListNode(1);
        linkedList.nextNode = node1;
        node1.prevNode = linkedList;

        LinkedListNode node2 = new LinkedListNode(2);
        node1.nextNode = node2;
        node2.prevNode = node1;

        LinkedListNode node3 = new LinkedListNode(3);
        node2.nextNode = node3;
        node3.prevNode = node2;

        return linkedList;
    }

    public static LinkedListNode createLinkedListFromArray(List<Integer> arr) {
        LinkedListNode head = new LinkedListNode(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            insertAtEnd(head, arr.get(i));
        }
        return head;
    }

    private static LinkedListNode insertAtEnd(LinkedListNode head, int data) {

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
}

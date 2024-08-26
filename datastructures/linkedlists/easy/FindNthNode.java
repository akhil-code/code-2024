package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

public class FindNthNode {

    public static void main(String[] args) {
        Node linkedList = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(linkedList);
        Node nthNode = findNthNode(linkedList, 1);
        System.out.println("Nth node: " + nthNode.data);

        Node nthNodeFromEnd = findNthNodeFromEnd(linkedList, 3);
        System.out.println("Nth node from end: " + nthNodeFromEnd.data);
    }

    private static Node findNthNode(Node head, int n) {
        Node currNode = head;
        for(int i=0;i<n-1;i++) {
            currNode = currNode.nextNode;
        }
        return currNode;
    }

    private static Node findNthNodeFromEnd(Node head, int n) {
        Node targetNode = head;
        Node currentNode = head;
        for (int i = 0; i < n; i++) {
            currentNode = currentNode.nextNode;
        }

        while(currentNode != null) {
            currentNode = currentNode.nextNode;
            targetNode = targetNode.nextNode;
        }
        return targetNode;
    }
}

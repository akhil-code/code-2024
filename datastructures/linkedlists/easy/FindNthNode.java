package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

public class FindNthNode {

    public static void main(String[] args) {
        LinkedListNode linkedList = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(linkedList);
        LinkedListNode nthNode = findNthNode(linkedList, 1);
        System.out.println("Nth node: " + nthNode.data);

        LinkedListNode nthNodeFromEnd = findNthNodeFromEnd(linkedList, 3);
        System.out.println("Nth node from end: " + nthNodeFromEnd.data);
    }

    public static LinkedListNode findNthNode(LinkedListNode head, int n) {
        LinkedListNode currNode = head;
        for(int i=0;i<n-1;i++) {
            currNode = currNode.nextNode;
        }
        return currNode;
    }

    public static LinkedListNode findNthNodeFromEnd(LinkedListNode head, int n) {
        LinkedListNode targetNode = head;
        LinkedListNode currentNode = head;
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

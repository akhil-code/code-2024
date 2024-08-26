package datastructures.linkedlists.basics;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

public class DetermineLength {

    public static void main(String[] args) {
        Node linkedList = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(linkedList);

        int size = findSize(linkedList);
        System.out.println(String.format("Length of linked list is : %d", size));

        int sizeRecursive = findSizeRecursive(linkedList);
        System.out.println(String.format("Length of linked list recursive is : %d", sizeRecursive));
    }

    private static int findSize(Node head) {
        int size = 0;
        Node currNode = head;
        while(currNode != null) {
            currNode = currNode.nextNode;
            size++;
        }
        return size;
    }

    private static int findSizeRecursive(Node head) {
        if(head != null) {
            return 1 + findSizeRecursive(head.nextNode);
        }
        return 0;
    }
}

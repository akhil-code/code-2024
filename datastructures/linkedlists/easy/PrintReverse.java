package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

public class PrintReverse {
    public static void main(String[] args) {
        Node head = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(head);

        printReverse(head);
    }


    public static void printReverse(Node head) {
        if(head == null) {
            return;
        }
        printReverse(head.nextNode);
        System.out.println(head.data);
    }
}

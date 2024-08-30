package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

public class PrintReverse {
    public static void main(String[] args) {
        LinkedListNode head = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(head);

        printReverse(head);
    }


    public static void printReverse(LinkedListNode head) {
        if(head == null) {
            return;
        }
        printReverse(head.nextNode);
        System.out.println(head.data);
    }
}

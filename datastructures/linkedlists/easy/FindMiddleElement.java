package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

public class FindMiddleElement {
    public static void main(String[] args) {
        Node linkedList = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(linkedList);
        Node middleNode = findMiddleNode(linkedList);
        System.out.println("middle node: " + middleNode.data);
    }

    private static Node findMiddleNode(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;
        while(fastPointer != null && fastPointer.nextNode != null) {
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;
        }

        if(fastPointer == null) {
            System.out.println("middle element 1: " + slowPointer.data);
            System.out.println("middle element 2: " + slowPointer.nextNode.data);
        } else {
            System.out.println(slowPointer.data);
        }
        return slowPointer;
    }
}

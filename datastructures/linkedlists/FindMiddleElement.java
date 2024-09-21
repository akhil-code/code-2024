package datastructures.linkedlists;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

public class FindMiddleElement {
    public static void main(String[] args) {
        LinkedListNode linkedList = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(linkedList);
        LinkedListNode middleNode = findMiddleNode(linkedList);
        System.out.println("middle node: " + middleNode.data);
    }

    public static LinkedListNode findMiddleNode(LinkedListNode head) {
        LinkedListNode slowPointer = head;
        LinkedListNode fastPointer = head;
        while(fastPointer != null && fastPointer.nextNode != null) {
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;
        }

        return slowPointer;
    }
}

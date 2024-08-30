package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

public class MoveLastElementToFirst {
    public static void main(String[] args) {
        LinkedListNode list = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(list);
        list = moveLastElementToFirst(list);
        LinkedListUtil.printLinkedList(list);

    }

    public static LinkedListNode moveLastElementToFirst(LinkedListNode head) {
        LinkedListNode lastNode;
        LinkedListNode prev = null;

        LinkedListNode currNode = head;
        while(currNode.nextNode != null) {
            prev = currNode;
            currNode = currNode.nextNode;
        }
        lastNode = currNode;

        prev.nextNode = null;
        lastNode.nextNode = head;
        return lastNode;
    }
}

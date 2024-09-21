package datastructures.linkedlists;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedListNode linkedList = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(linkedList);

        LinkedListNode reversedLinkedList = reverseLinkedList(linkedList);
        LinkedListUtil.printLinkedList(reversedLinkedList);
    }

    public static LinkedListNode reverseLinkedList(LinkedListNode head) {
        LinkedListNode prev = null, curr = head, next = curr.nextNode;

        while(curr != null) {
            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

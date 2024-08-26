package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node linkedList = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(linkedList);

        Node reversedLinkedList = reverseLinkedList(linkedList);
        LinkedListUtil.printLinkedList(reversedLinkedList);
    }

    public static Node reverseLinkedList(Node head) {
        Node prev = null, curr = head, next = curr.nextNode;

        while(curr != null) {
            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

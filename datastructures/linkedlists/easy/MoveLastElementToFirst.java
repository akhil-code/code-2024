package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

public class MoveLastElementToFirst {
    public static void main(String[] args) {
        Node list = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(list);
        list = moveLastElementToFirst(list);
        LinkedListUtil.printLinkedList(list);

    }

    public static Node moveLastElementToFirst(Node head) {
        Node lastNode;
        Node prev = null;

        Node currNode = head;
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

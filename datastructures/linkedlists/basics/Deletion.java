package datastructures.linkedlists.basics;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

public class Deletion {

    public static void main(String[] args) {
        Node linkedList = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(linkedList);
        linkedList = deleteKey(linkedList, 3);
        LinkedListUtil.printLinkedList(linkedList);
        linkedList = deleteKey(linkedList, 6);
        LinkedListUtil.printLinkedList(linkedList);
        linkedList = deleteKey(linkedList, 0);
        LinkedListUtil.printLinkedList(linkedList);
    }

    private static Node deleteKey(Node head, int key) {

        if(key == head.data) {
            Node newHead = head.nextNode;
            head.nextNode = null;
            return newHead;
        }

        Node prevNode = null;
        Node currNode = head;
        while(currNode.data != key) {
            prevNode = currNode;
            currNode = currNode.nextNode;
        }

        prevNode.nextNode = currNode.nextNode;
        return head;
    }

}

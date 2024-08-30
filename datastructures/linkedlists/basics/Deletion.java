package datastructures.linkedlists.basics;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

public class Deletion {

    public static void main(String[] args) {
        LinkedListNode linkedList = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(linkedList);
        linkedList = deleteKey(linkedList, 3);
        LinkedListUtil.printLinkedList(linkedList);
        linkedList = deleteKey(linkedList, 6);
        LinkedListUtil.printLinkedList(linkedList);
        linkedList = deleteKey(linkedList, 0);
        LinkedListUtil.printLinkedList(linkedList);
    }

    private static LinkedListNode deleteKey(LinkedListNode head, int key) {

        if(key == head.data) {
            LinkedListNode newHead = head.nextNode;
            head.nextNode = null;
            return newHead;
        }

        LinkedListNode prevNode = null;
        LinkedListNode currNode = head;
        while(currNode.data != key) {
            prevNode = currNode;
            currNode = currNode.nextNode;
        }

        prevNode.nextNode = currNode.nextNode;
        return head;
    }

}

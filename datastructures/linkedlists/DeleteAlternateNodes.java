package datastructures.linkedlists;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

public class DeleteAlternateNodes {
    public static void main(String[] args) {
        LinkedListNode list = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(list);

        deleteAlternateNodes(list);
        LinkedListUtil.printLinkedList(list);
    }

    public static void deleteAlternateNodes(LinkedListNode head) {
        LinkedListNode curr = head;
        while(curr != null && curr.nextNode != null) {
            curr.nextNode = curr.nextNode.nextNode;
            curr = curr.nextNode;
        }
    }
}

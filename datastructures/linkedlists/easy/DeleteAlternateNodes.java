package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

public class DeleteAlternateNodes {
    public static void main(String[] args) {
        Node list = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(list);

        deleteAlternateNodes(list);
        LinkedListUtil.printLinkedList(list);
    }

    public static void deleteAlternateNodes(Node head) {
        Node curr = head;
        while(curr != null && curr.nextNode != null) {
            curr.nextNode = curr.nextNode.nextNode;
            curr = curr.nextNode;
        }
    }
}

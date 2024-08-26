package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

public class PairwiseSwap {
    public static void main(String[] args) {
        Node list = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(list);

        Node swappedList = pairwiseSwap(list);
        LinkedListUtil.printLinkedList(swappedList);
    }

    public static Node pairwiseSwap(Node head) {
        Node prev = null;
        Node curr = head;

        Node newHead = null;

        while(curr != null && curr.nextNode != null) {
            Node nextNode = curr.nextNode;
            if(prev == null) {
                newHead = nextNode;
            } else {
                prev.nextNode = nextNode;
            }
            curr.nextNode = nextNode.nextNode;
            nextNode.nextNode = curr;
            prev = curr;
            curr = curr.nextNode;

        }
        return newHead;
    }
}

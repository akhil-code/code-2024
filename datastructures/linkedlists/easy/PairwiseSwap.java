package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

public class PairwiseSwap {
    public static void main(String[] args) {
        LinkedListNode list = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(list);

        LinkedListNode swappedList = pairwiseSwap(list);
        LinkedListUtil.printLinkedList(swappedList);
    }

    public static LinkedListNode pairwiseSwap(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode curr = head;

        LinkedListNode newHead = null;

        while(curr != null && curr.nextNode != null) {
            LinkedListNode nextNode = curr.nextNode;
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

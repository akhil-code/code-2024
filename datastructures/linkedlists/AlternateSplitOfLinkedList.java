package datastructures.linkedlists;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

public class AlternateSplitOfLinkedList {
    public static void main(String[] args) {
        LinkedListNode list = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(list);

        LinkedListNode splitList = alternateSplit(list);

        LinkedListUtil.printLinkedList(list);
        LinkedListUtil.printLinkedList(splitList);
    }


    public static LinkedListNode alternateSplit(LinkedListNode head) {
        if(head == null) {
            return null;
        }
        LinkedListNode splitList = head.nextNode;

        LinkedListNode curr = head;
        LinkedListNode prev = null;

        while(curr != null && curr.nextNode != null) {
            LinkedListNode nextNode = curr.nextNode;
            curr.nextNode = nextNode.nextNode;
            if(prev != null) {
                prev.nextNode = nextNode;
            }
            prev = nextNode;
            curr = curr.nextNode;
        }

        return splitList;
    }

}

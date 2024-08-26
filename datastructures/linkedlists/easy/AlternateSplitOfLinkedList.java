package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

public class AlternateSplitOfLinkedList {
    public static void main(String[] args) {
        Node list = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(list);

        Node splitList = alternateSplit(list);

        LinkedListUtil.printLinkedList(list);
        LinkedListUtil.printLinkedList(splitList);
    }


    public static Node alternateSplit(Node head) {
        if(head == null) {
            return null;
        }
        Node splitList = head.nextNode;

        Node curr = head;
        Node prev = null;

        while(curr != null && curr.nextNode != null) {
            Node nextNode = curr.nextNode;
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

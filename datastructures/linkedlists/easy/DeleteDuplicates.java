package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

import java.util.Arrays;

public class DeleteDuplicates {
    public static void main(String[] args) {
        Node list = LinkedListUtil
                .createLinkedListFromArray(Arrays.asList(1, 3, 3, 5, 6, 7, 8, 9, 9, 10, 11, 11, 111));
        LinkedListUtil.printLinkedList(list);
        removeDuplicates(list);
        LinkedListUtil.printLinkedList(list);
    }

    public static void removeDuplicates(Node head) {
        while(head != null && head.nextNode != null) {
            if(head.data == head.nextNode.data) {
                Node nextNode = head.nextNode.nextNode;
                head.nextNode = nextNode;
            }
            head = head.nextNode;
        }
    }
}

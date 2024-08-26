package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

import java.util.Arrays;

public class Mergesort {
    public static void main(String[] args) {
        Node list = LinkedListUtil
                .createLinkedListFromArray(Arrays.asList(7, 2, 7, 10, 34, 54, 22));
        LinkedListUtil.printLinkedList(list);
        list = mergeSort(list);
        LinkedListUtil.printLinkedList(list);
    }

    public static Node mergeSort(Node head) {
        if(head == null || head.nextNode == null) {
            return head;
        }

        Node midNode = FindMiddleElement.findMiddleNode(head);


        Node halfList = midNode.nextNode;
        midNode.nextNode = null;
        return MergeSortedLinkedLists.mergeSortedLinkedLists(mergeSort(head), mergeSort(halfList));
    }
}

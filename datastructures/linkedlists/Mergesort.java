package datastructures.linkedlists;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

import java.util.Arrays;

public class Mergesort {
    public static void main(String[] args) {
        LinkedListNode list = LinkedListUtil
                .createLinkedListFromArray(Arrays.asList(7, 2, 7, 10, 34, 54, 22));
        LinkedListUtil.printLinkedList(list);
        list = mergeSort(list);
        LinkedListUtil.printLinkedList(list);
    }

    public static LinkedListNode mergeSort(LinkedListNode head) {
        if(head == null || head.nextNode == null) {
            return head;
        }

        LinkedListNode midNode = FindMiddleElement.findMiddleNode(head);


        LinkedListNode halfList = midNode.nextNode;
        midNode.nextNode = null;
        return MergeSortedLinkedLists.mergeSortedLinkedLists(mergeSort(head), mergeSort(halfList));
    }
}

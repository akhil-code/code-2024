package datastructures.linkedlists;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

import java.util.Arrays;

public class MergeSortedLinkedLists {

    public static void main(String[] args) {
        LinkedListNode list1 = LinkedListUtil
                .createLinkedListFromArray(Arrays.asList(10, 22, 40, 80, 90));
        LinkedListNode list2 = LinkedListUtil
                .createLinkedListFromArray(Arrays.asList(12, 14, 44, 45, 46, 99, 100));

        LinkedListNode mergedList = mergeSortedLinkedLists(list1, list2);
        LinkedListUtil.printLinkedList(mergedList);
    }

    public static LinkedListNode mergeSortedLinkedLists(LinkedListNode list1, LinkedListNode list2) {
        LinkedListNode head = null;
        LinkedListNode curr = null;
        LinkedListNode curr1 = list1, curr2 = list2;
        if(curr1.data < curr2.data) {
            curr = head = curr1;
            curr1 = curr1.nextNode;
        } else {
            curr = head = curr2;
            curr2 = curr2.nextNode;
        }

        while(curr1 != null & curr2 != null) {
            if(curr1.data < curr2.data) {
                curr.nextNode = curr1;
                curr1 = curr1.nextNode;
            } else {
                curr.nextNode = curr2;
                curr2 = curr2.nextNode;
            }
            curr = curr.nextNode;
        }

        while(curr1 != null) {
            curr.nextNode = curr1;
            curr1 = curr1.nextNode;
            curr = curr.nextNode;
        }

        while(curr2 != null) {
            curr.nextNode = curr2;
            curr2 = curr2.nextNode;
            curr = curr.nextNode;
        }
        return head;
    }
}

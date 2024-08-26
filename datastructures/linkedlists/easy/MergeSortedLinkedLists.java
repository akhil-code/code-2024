package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

import java.util.Arrays;

public class MergeSortedLinkedLists {

    public static void main(String[] args) {
        Node list1 = LinkedListUtil
                .createLinkedListFromArray(Arrays.asList(10, 22, 40, 80, 90));
        Node list2 = LinkedListUtil
                .createLinkedListFromArray(Arrays.asList(12, 14, 44, 45, 46, 99, 100));

        Node mergedList = mergeSortedLinkedLists(list1, list2);
        LinkedListUtil.printLinkedList(mergedList);
    }

    public static Node mergeSortedLinkedLists(Node list1, Node list2) {
        Node head = null;
        Node curr = null;
        Node curr1 = list1, curr2 = list2;
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

package datastructures.linkedlists;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

import java.util.Arrays;

public class CheckIfPalindrome {
    public static void main(String[] args) {
        LinkedListNode linkedList = LinkedListUtil
                .createLinkedListFromArray(Arrays.asList(1, 2, 3, 4, 5, 5, 6, 4, 3, 2, 1));

        System.out.println(checkForPalindrome(linkedList));

    }

    public static boolean checkForPalindrome(LinkedListNode linkedList) {
        LinkedListNode middleNode = FindMiddleElement.findMiddleNode(linkedList);
        LinkedListNode firstHalf = linkedList;
        LinkedListNode secondHalf = middleNode.nextNode;
        secondHalf = ReverseLinkedList.reverseLinkedList(secondHalf);
        middleNode.nextNode = null;

        LinkedListNode curr1 = firstHalf;
        LinkedListNode curr2 = secondHalf;

        boolean isPalindrome = true;
        while(curr1 != null && curr2 != null) {
            if(curr1.data == curr2.data) {
                curr1 = curr1.nextNode;
                curr2 = curr2.nextNode;
            } else {
                isPalindrome = false;
                break;
            }
        }

        secondHalf = ReverseLinkedList.reverseLinkedList(secondHalf);
        middleNode.nextNode = secondHalf;

        return isPalindrome;

    }
}

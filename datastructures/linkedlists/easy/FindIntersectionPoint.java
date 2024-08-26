package datastructures.linkedlists.easy;

import datastructures.linkedlists.basics.DetermineLength;
import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

import java.util.Arrays;

public class FindIntersectionPoint {
    public static void main(String[] args) {
        Node list1 = LinkedListUtil
                .createLinkedListFromArray(Arrays.asList(1, 2, 3, 4, 5, 6));
        Node midNode = FindMiddleElement.findMiddleNode(list1);

        Node list2 = LinkedListUtil
                .createLinkedListFromArray(Arrays.asList(100, 220, 300));

        Node lastNode = findLastNode(list2);
        lastNode.nextNode = midNode;

        LinkedListUtil.printLinkedList(list1);
        LinkedListUtil.printLinkedList(list2);

        Node intersectionPoint = findIntersectionPoint(list1, list2);

        System.out.println(intersectionPoint.data);
    }

    public static Node findLastNode(Node head) {
        while(head.nextNode != null) {
            head = head.nextNode;
        }
        return head;
    }

    public static Node findIntersectionPoint(Node list1, Node list2) {
        int n1 = DetermineLength.findSize(list1);
        int n2 = DetermineLength.findSize(list2);

        Node curr1 = list1, curr2 = list2;

        int diff = n1 - n2;
        if(diff > 0) {
            for (int i = 0; i < diff; i++) {
                curr1 = curr1.nextNode;
            }
        } else {
            while(diff < 0) {
                curr2 = curr2.nextNode;
                diff++;
            }
        }

        while(curr1 != null & curr2 != null) {
            if(curr1 == curr2) {
                return curr1;
            }
            curr1 = curr1.nextNode;
            curr2 = curr2.nextNode;
        }
        return null;
    }
}

package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

public class AddTwoLinkedLists {
    public static void main(String[] args) {
        Node list1 = LinkedListUtil.createDummyLinkedList();
        Node list2 = LinkedListUtil.createDummyLinkedList();

        LinkedListUtil.printLinkedList(list1);
        LinkedListUtil.printLinkedList(list2);

        Node sumList = addLinkedLists(list1, list2);
        LinkedListUtil.printLinkedList(sumList);
    }

    public static Node addLinkedLists(Node list1, Node list2) {
        list1 = ReverseLinkedList.reverseLinkedList(list1);
        list2 = ReverseLinkedList.reverseLinkedList(list2);


        Node sumList = new Node(0);
        Node sumListHead = sumList;

        int carryOver = 0;
        while(list1 != null && list2 != null) {
            int reminder = (list1.data + list2.data + carryOver) % 10;
             carryOver = (list1.data + list2.data + carryOver) / 10;

            list1 = list1.nextNode;
            list2 = list2.nextNode;

            sumList.nextNode = new Node(reminder);
            sumList = sumList.nextNode;
        }

        if(carryOver > 0) {
            sumList.nextNode = new Node(carryOver);
        }

        sumListHead = sumListHead.nextNode;
        return ReverseLinkedList.reverseLinkedList(sumListHead);
    }
}

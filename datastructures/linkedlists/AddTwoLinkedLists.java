package datastructures.linkedlists;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

public class AddTwoLinkedLists {
    public static void main(String[] args) {
        LinkedListNode list1 = LinkedListUtil.createDummyLinkedList();
        LinkedListNode list2 = LinkedListUtil.createDummyLinkedList();

        LinkedListUtil.printLinkedList(list1);
        LinkedListUtil.printLinkedList(list2);

        LinkedListNode sumList = addLinkedLists(list1, list2);
        LinkedListUtil.printLinkedList(sumList);
    }

    public static LinkedListNode addLinkedLists(LinkedListNode list1, LinkedListNode list2) {
        list1 = ReverseLinkedList.reverseLinkedList(list1);
        list2 = ReverseLinkedList.reverseLinkedList(list2);


        LinkedListNode sumList = new LinkedListNode(0);
        LinkedListNode sumListHead = sumList;

        int carryOver = 0;
        while(list1 != null && list2 != null) {
            int reminder = (list1.data + list2.data + carryOver) % 10;
             carryOver = (list1.data + list2.data + carryOver) / 10;

            list1 = list1.nextNode;
            list2 = list2.nextNode;

            sumList.nextNode = new LinkedListNode(reminder);
            sumList = sumList.nextNode;
        }

        if(carryOver > 0) {
            sumList.nextNode = new LinkedListNode(carryOver);
        }

        sumListHead = sumListHead.nextNode;
        return ReverseLinkedList.reverseLinkedList(sumListHead);
    }
}

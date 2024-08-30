package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

public class StartingPointOfLoop {
    public static void main(String[] args) {
        LinkedListNode list = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(list);

        LinkedListNode nthNode = FindNthNode.findNthNode(list, 3);
        System.out.println("setting the loop start node as : " + nthNode.data);
        LinkedListNode lastNode = FindNthNode.findNthNodeFromEnd(list, 1);
        lastNode.nextNode = nthNode;

        LinkedListNode findStartingPoint = findStartingPointOfLoop(list);
        System.out.println("starting node of loop identified: " + findStartingPoint.data);

        int loopSize = findLengthOfLoop(list);
        System.out.println("loop size: " + loopSize);

        int linkedListSize = findNumberOfNodesInLoopedLinkedList(list);
        System.out.printf("Linked list size: " + linkedListSize);
    }

    public static int findLengthOfLoop(LinkedListNode head) {
        LinkedListNode slowPointer = head;
        LinkedListNode fastPointer = head;

        while(fastPointer != null && fastPointer.nextNode != null) {
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;
            if(slowPointer == fastPointer) {
                break;
            }
        }

        int count = 1;
        fastPointer = fastPointer.nextNode;
        while(fastPointer != slowPointer) {
            fastPointer = fastPointer.nextNode;
            count++;
        }
        return count;
    }

    public static LinkedListNode findStartingPointOfLoop(LinkedListNode head) {
        LinkedListNode slowPointer = head;
        LinkedListNode fastPointer = head;

        while(fastPointer != null && fastPointer.nextNode != null) {
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;
            if(slowPointer == fastPointer) {
                break;
            }
        }

        LinkedListNode curNode = null;
        if(slowPointer == fastPointer) {
            curNode = head;
        }
        while(curNode != null && curNode != slowPointer) {
            curNode = curNode.nextNode;
            slowPointer = slowPointer.nextNode;
        }
        return curNode;
    }

    public static int findNumberOfNodesInLoopedLinkedList(LinkedListNode head) {
        LinkedListNode loopStartPoint = findStartingPointOfLoop(head);
        int lengthOfLoop = findLengthOfLoop(head) - 1;

        int count = 1;
        while(head != loopStartPoint) {
            count++;
            head = head.nextNode;
        }
        return count + lengthOfLoop;
    }
}

package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

public class StartingPointOfLoop {
    public static void main(String[] args) {
        Node list = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(list);

        Node nthNode = FindNthNode.findNthNode(list, 3);
        System.out.println("setting the loop start node as : " + nthNode.data);
        Node lastNode = FindNthNode.findNthNodeFromEnd(list, 1);
        lastNode.nextNode = nthNode;

        Node findStartingPoint = findStartingPointOfLoop(list);
        System.out.println("starting node of loop identified: " + findStartingPoint.data);

        int loopSize = findLengthOfLoop(list);
        System.out.println("loop size: " + loopSize);

        int linkedListSize = findNumberOfNodesInLoopedLinkedList(list);
        System.out.printf("Linked list size: " + linkedListSize);
    }

    public static int findLengthOfLoop(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

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

    public static Node findStartingPointOfLoop(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while(fastPointer != null && fastPointer.nextNode != null) {
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;
            if(slowPointer == fastPointer) {
                break;
            }
        }

        Node curNode = null;
        if(slowPointer == fastPointer) {
            curNode = head;
        }
        while(curNode != null && curNode != slowPointer) {
            curNode = curNode.nextNode;
            slowPointer = slowPointer.nextNode;
        }
        return curNode;
    }

    public static int findNumberOfNodesInLoopedLinkedList(Node head) {
        Node loopStartPoint = findStartingPointOfLoop(head);
        int lengthOfLoop = findLengthOfLoop(head) - 1;

        int count = 1;
        while(head != loopStartPoint) {
            count++;
            head = head.nextNode;
        }

        return count + lengthOfLoop;
    }
}

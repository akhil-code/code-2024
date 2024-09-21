package datastructures.linkedlists;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

public class DetectLoop {

    public static void main(String[] args) {
        LinkedListNode linkedList = LinkedListUtil.createDummyLinkedList();
        System.out.println("loop exists: " + detectLoop(linkedList));
        LinkedListNode tailNode = FindNthNode.findNthNodeFromEnd(linkedList, 1);
        LinkedListNode midNode = FindNthNode.findNthNode(linkedList, 3);
        tailNode.nextNode = midNode;
        System.out.println("loop exists: " + detectLoop(linkedList));
    }
    public static boolean detectLoop(LinkedListNode head) {
        boolean loopExists = false;
        LinkedListNode slowPointer = head;
        LinkedListNode fastPointer = head;
        while(fastPointer != null && fastPointer.nextNode != null) {
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;
            if(slowPointer == fastPointer) {
                loopExists = true;
                break;
            }
        }
        return loopExists;
    }
}

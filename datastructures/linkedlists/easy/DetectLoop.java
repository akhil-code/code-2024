package datastructures.linkedlists.easy;

import datastructures.linkedlists.model.Node;
import datastructures.linkedlists.util.LinkedListUtil;

public class DetectLoop {

    public static void main(String[] args) {
        Node linkedList = LinkedListUtil.createDummyLinkedList();
        System.out.println("loop exists: " + detectLoop(linkedList));
        Node tailNode = FindNthNode.findNthNodeFromEnd(linkedList, 1);
        Node midNode = FindNthNode.findNthNode(linkedList, 3);
        tailNode.nextNode = midNode;
        System.out.println("loop exists: " + detectLoop(linkedList));
    }
    public static boolean detectLoop(Node head) {
        boolean loopExists = false;
        Node slowPointer = head;
        Node fastPointer = head;
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

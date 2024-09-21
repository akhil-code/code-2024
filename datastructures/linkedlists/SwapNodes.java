package datastructures.linkedlists;

import datastructures.linkedlists.model.LinkedListNode;
import datastructures.linkedlists.util.LinkedListUtil;

public class SwapNodes {

    public static void main(String[] args) {
        LinkedListNode linkedList = LinkedListUtil.createDummyLinkedList();
        LinkedListUtil.printLinkedList(linkedList);
        linkedList = swapNodesWithoutSwappingData(linkedList, 0, 1);
        LinkedListUtil.printLinkedList(linkedList);
    }

    // Bug - Doesn't work when x and y are adjacent nodes of the linked list and either one of them is a head.
    private static LinkedListNode swapNodesWithoutSwappingData(LinkedListNode head, int x, int y) {
        // search for x and y
        LinkedListNode currNode = head;
        LinkedListNode nodeX = null;
        LinkedListNode prevX = null;
        LinkedListNode nodeY = null;
        LinkedListNode prevY = null;
        while(currNode != null) {
            if(currNode.data == x) {
                nodeX = currNode;
                break;
            }
            prevX = currNode;
            currNode = currNode.nextNode;
        }

        currNode = head;
        while(currNode != null) {
            if(currNode.data == y) {
                nodeY = currNode;
                break;
            }
            prevY = currNode;
            currNode = currNode.nextNode;
        }

        // case 1 : if either of the target element is not present,
        // don't swap
        if(nodeX == null || nodeY == null) {
            System.out.println("No node with data X or Y found");
            return head;
        }
        // case 2 : if the target elements are adjacent to each other
        else if(prevY == nodeX) {
            prevX.nextNode = nodeY;
            nodeX.nextNode = nodeY.nextNode;
            nodeY.nextNode = nodeX;
            return head;
        }
        else if(prevX == nodeY) {
            prevY.nextNode = nodeX;
            nodeY.nextNode = nodeX.nextNode;
            nodeX.nextNode = nodeY;
            return head;
        }
        else if(prevX == null) {
            prevY.nextNode = nodeX;
            LinkedListNode temp = nodeX.nextNode;
            nodeX.nextNode = nodeY.nextNode;
            nodeY.nextNode = temp;
            return nodeY;
        } else if(prevY == null) {
            prevX.nextNode = nodeY;
            LinkedListNode temp =  nodeY.nextNode;
            nodeY.nextNode = nodeX.nextNode;
            nodeX.nextNode = temp;
            return nodeX;
        }
        // case 4 :
        prevX.nextNode = nodeY;
        prevY.nextNode = nodeX;

        LinkedListNode temp = nodeX.nextNode;
        nodeX.nextNode = nodeY.nextNode;
        nodeY.nextNode = temp;
        return head;
    }
}

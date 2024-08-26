package datastructures.linkedlists.model;

public class Util {

    static void printLinkedList(Node head) {
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.nextNode;
        }
        System.out.println("null");
    }
}

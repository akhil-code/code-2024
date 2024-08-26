package datastructures.linkedlists.model;

public class LinkedListUtil {

    public static void printLinkedList(Node head) {
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.nextNode;
        }
        System.out.println("null");
    }

    public static Node createDummyLinkedList() {
        Node linkedList1 = new Node(0);
        linkedList1.nextNode = new Node(1);
        linkedList1.nextNode.nextNode = new Node(2);
        linkedList1.nextNode.nextNode.nextNode = new Node(3);
        linkedList1.nextNode.nextNode.nextNode.nextNode = new Node(4);
        linkedList1.nextNode.nextNode.nextNode.nextNode.nextNode = new Node(5);
        linkedList1.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode = new Node(6);
        return linkedList1;
    }
}

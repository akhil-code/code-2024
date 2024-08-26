package datastructures.linkedlists.model;

public class Insertion {

    public static void main(String[] args) {
        Node linkedList1 = createDummyLinkedList();
        linkedList1 = insertAtStart(linkedList1, -1);
        linkedList1 = insertAtEnd(linkedList1, 25);
        linkedList1 = insertAtIndex(linkedList1, 2, 999);
        Util.printLinkedList(linkedList1);
    }

    private static Node createDummyLinkedList() {
        Node linkedList1 = new Node(0);
        linkedList1.nextNode = new Node(1);
        linkedList1.nextNode.nextNode = new Node(2);
        linkedList1.nextNode.nextNode.nextNode = new Node(3);
        linkedList1.nextNode.nextNode.nextNode.nextNode = new Node(4);
        linkedList1.nextNode.nextNode.nextNode.nextNode.nextNode = new Node(5);
        linkedList1.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode = new Node(6);
        return linkedList1;
    }


    public static Node insertAtStart(Node head, int data) {
        Node newNode = new Node(data);
        newNode.nextNode = head;
        return newNode;
    }

    public static Node insertAtEnd(Node head, int data) {

        if(head == null) {
            return new Node(data);
        }

        Node currNode = head;
        while(currNode.nextNode != null) {
            currNode = currNode.nextNode;
        }
        currNode.nextNode = new Node(data);
        return head;
    }

    public static Node insertAtIndex(Node head, int index, int data) {
        if (index == 0) {
            return new Node(data);
        }

        int i = 0;
        Node currNode = head;
        while(i < index-1 && currNode != null) {
            currNode = currNode.nextNode;
            i++;
        }

        Node newNode = new Node(data);
        newNode.nextNode = currNode.nextNode;
        currNode.nextNode = newNode;
        return head;
    }
}

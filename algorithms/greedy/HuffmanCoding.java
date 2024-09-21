package algorithms.greedy;


import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCoding {
    public static void main(String[] args) {

        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };

        Node huffmanTree = huffmanCoding(charArray, charfreq);
        printHuffmanTree(huffmanTree, "");

    }

    public static void printHuffmanTree(Node tree, String currCode) {
        if(tree == null) {
            return;
        }
        if(tree.left == null && tree.right == null) {
            System.out.println(tree.data + " : " + currCode);
        }
        printHuffmanTree(tree.left, currCode + "0");
        printHuffmanTree(tree.right, currCode + "1");
    }

    public static Node huffmanCoding(char[] arr, int[] freq) {
        // create priority queue
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(node -> node.freq));
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            pq.add(new Node(freq[i], arr[i]));
        }

        // create tree
        while(!pq.isEmpty()) {
            if(pq.size() == 1) {
                return pq.poll();
            }

            Node node1 = pq.poll();
            Node node2 = pq.poll();

            Node newNode = new Node(node1.freq + node2.freq);
            newNode.left = node1;
            newNode.right = node2;
            pq.add(newNode);
        }
        return null;
    }

    static class Node {
        int freq;
        char data;
        Node left;
        Node right;

        public Node(int freq) {
            this.freq = freq;
            this.left = this.right = null;
        }

        public Node(int freq, char data) {
            this.freq = freq;
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}

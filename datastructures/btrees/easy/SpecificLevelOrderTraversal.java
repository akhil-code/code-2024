package datastructures.btrees.easy;

import datastructures.btrees.BTreeUtil;
import datastructures.btrees.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SpecificLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);

        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);

        root.left.left.left = new BinaryTreeNode(8);
        root.left.left.right = new BinaryTreeNode(9);
        root.left.right.left = new BinaryTreeNode(10);
        root.left.right.right = new BinaryTreeNode(11);
        root.right.left.left = new BinaryTreeNode(12);
        root.right.left.right = new BinaryTreeNode(13);
        root.right.right.left = new BinaryTreeNode(14);
        root.right.right.right = new BinaryTreeNode(15);

        root.left.left.left.left = new BinaryTreeNode(16);
        root.left.left.left.right = new BinaryTreeNode(17);
        root.left.left.right.left = new BinaryTreeNode(18);
        root.left.left.right.right = new BinaryTreeNode(19);
        root.left.right.left.left = new BinaryTreeNode(20);
        root.left.right.left.right = new BinaryTreeNode(21);
        root.left.right.right.left = new BinaryTreeNode(22);
        root.left.right.right.right = new BinaryTreeNode(23);
        root.right.left.left.left = new BinaryTreeNode(24);
        root.right.left.left.right = new BinaryTreeNode(25);
        root.right.left.right.left = new BinaryTreeNode(26);
        root.right.left.right.right = new BinaryTreeNode(27);
        root.right.right.left.left = new BinaryTreeNode(28);
        root.right.right.left.right = new BinaryTreeNode(29);
        root.right.right.right.left = new BinaryTreeNode(30);
        root.right.right.right.right = new BinaryTreeNode(31);

        printSpecificLevelOrder(root);
    }

    public static void printSpecificLevelOrder(BinaryTreeNode node) {
        List<Integer> output = new ArrayList<>();
        output.add(node.data);

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(node.left);
        queue.add(node.right);

        while (!queue.isEmpty()) {
            BinaryTreeNode node1 = queue.poll();
            BinaryTreeNode node2 = queue.poll();

            System.out.println(node1.data + ", " + node2.data);

            output.add(node1.data);
            output.add(node2.data);

            if(!BTreeUtil.isLeafNode(node1) && !BTreeUtil.isLeafNode(node2)) {
                queue.add(node1.left);
                queue.add(node2.right);
                queue.add(node1.right);
                queue.add(node2.left);
            }

        }

        System.out.println("traversal: " + output);
    }
    
}

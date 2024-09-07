package datastructures.btrees.medium;

import datastructures.btrees.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftAndRightView {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(7);
        root.left.right = new BinaryTreeNode(8);
        root.right.right = new BinaryTreeNode(15);
        root.right.left = new BinaryTreeNode(12);
        root.right.right.left = new BinaryTreeNode(14);

        printLeftView(root);
        printRightView(root);
    }

    public static void printLeftView(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSize = queue.size();
        boolean levelStart = true;
        while(!queue.isEmpty()) {
            BinaryTreeNode currNode = queue.poll();
            levelSize--;
            if(levelStart) {
                System.out.println(currNode.data);
                levelStart = false;
            }

            if(currNode.left != null) {
                queue.add(currNode.left);
            }
            if(currNode.right != null) {
                queue.add(currNode.right);
            }
            if(levelSize == 0) {
                levelSize = queue.size();
                levelStart = true;
            }
        }
    }


    public static void printRightView(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSize = queue.size();
        boolean levelStart = true;
        while(!queue.isEmpty()) {
            BinaryTreeNode currNode = queue.poll();
            levelSize--;
            if(levelStart) {
                System.out.println(currNode.data);
                levelStart = false;
            }

            if(currNode.right != null) {
                queue.add(currNode.right);
            }
            if(currNode.left != null) {
                queue.add(currNode.left);
            }
            if(levelSize == 0) {
                levelSize = queue.size();
                levelStart = true;
            }
        }
    }
}

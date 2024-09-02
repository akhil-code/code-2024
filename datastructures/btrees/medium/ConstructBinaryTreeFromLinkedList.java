package datastructures.btrees.medium;

import datastructures.btrees.model.BinaryTreeNode;
import datastructures.btrees.traversals.bfs.LevelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinaryTreeFromLinkedList {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.right = new BinaryTreeNode(12);
        root.right.right = new BinaryTreeNode(15);
        root.right.right.right = new BinaryTreeNode(25);
        root.right.right.right.right = new BinaryTreeNode(30);
        root.right.right.right.right.right = new BinaryTreeNode(36);

        BinaryTreeNode tree = constructTreeFromLinkedList(root);
        LevelOrderTraversal.levelOrderTraversal(tree);
    }


    public static BinaryTreeNode constructTreeFromLinkedList(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        BinaryTreeNode currNode = node.right;
        BinaryTreeNode treeRoot = node;
        queue.add(treeRoot);
        while(currNode != null && !queue.isEmpty()) {
            BinaryTreeNode treeNode = queue.poll();
            treeNode.left = currNode;
            queue.add(treeNode.left);
            currNode = currNode.right;
            emptyChildren(treeNode.left);

            if(currNode != null) {
                treeNode.right = currNode;
                currNode = currNode.right;
                queue.add(treeNode.right);
                emptyChildren(treeNode.right);
            }
        }
        return treeRoot;
    }

    private static void emptyChildren(BinaryTreeNode node) {
        if(node != null) {
            node.left = null;
            node.right = null;
        }
    }
}

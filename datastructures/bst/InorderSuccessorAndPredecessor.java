package datastructures.bst;

import datastructures.btrees.model.BinaryTreeNode;
import datastructures.btrees.traversals.bfs.LevelOrderTraversal;
import datastructures.btrees.traversals.dfs.InorderTraversal;

public class InorderSuccessorAndPredecessor {

    public static void main(String[] args) {
        int key = 60;

        BinaryTreeNode root = new BinaryTreeNode(50);
        Insertion.insert(root, 30);
        Insertion.insert(root, 20);
        Insertion.insert(root, 40);
        Insertion.insert(root, 70);
        Insertion.insert(root, 60);
        Insertion.insert(root, 80);

        LevelOrderTraversal.levelOrderTraversal(root);

        BinaryTreeNode successor = getInorderSuccessor(root, key);
        BinaryTreeNode predecessor = getInorderPredecessor(root, key);

        System.out.println(successor.data);
        System.out.println(predecessor.data);
    }

    public static BinaryTreeNode getInorderSuccessor(BinaryTreeNode node, int target) {
        if(node == null) {
            return null;
        }

        if(target > node.data) {
            return getInorderSuccessor(node, target);
        }

        BinaryTreeNode successor = getInorderSuccessor(node.left, target);
        return null;

    }

    public static BinaryTreeNode getInorderPredecessor(BinaryTreeNode node, int target) {
        node = node.left;
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }
}

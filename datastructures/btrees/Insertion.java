package datastructures.btrees;

import datastructures.btrees.BTreeUtil;
import datastructures.btrees.model.BinaryTreeNode;
import datastructures.btrees.traversals.bfs.LevelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class Insertion {
    public static void main(String[] args) {
        BinaryTreeNode tree = BTreeUtil.createDummyTree();
        tree = insert(tree, 1);
        tree = insert(tree, 1);
        tree = insert(tree, 1);
        tree = insert(tree, 1);

        System.out.println("Level order traversal: ");
        LevelOrderTraversal.levelOrderTraversal(tree);

    }

    public static BinaryTreeNode insert(BinaryTreeNode root, int data) {
        if(root == null) {
            root = new BinaryTreeNode(data);
            return root;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            BinaryTreeNode currNode = queue.remove();
            if(currNode.left == null) {
                currNode.left = new BinaryTreeNode(data);
                return root;
            } else {
                queue.add(currNode.left);
            }

            if(currNode.right == null) {
                currNode.right = new BinaryTreeNode(data);
                return root;
            } else {
                queue.add(currNode.right);
            }
        }

        return root;
    }
}

package datastructures.btrees.medium;

import datastructures.btrees.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindMaxDepth {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        System.out.println(findMaxDepth(root));
        System.out.println(findDepthIterative(root));
    }

    public static int findMaxDepth(BinaryTreeNode node) {
        if(node == null) {
            return 0;
        }
        return Math.max(1 + findMaxDepth(node.left), 1 + findMaxDepth(node.right));
    }

    public static int findDepthIterative(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        int levelSize = 1;
        while(!queue.isEmpty()) {
            BinaryTreeNode currNode = queue.poll();
            levelSize--;
            if(currNode.left != null) {
                queue.add(currNode.left);
            }
            if(currNode.right != null) {
                queue.add(currNode.right);
            }
            if(levelSize == 0) {
                depth++;
                levelSize = queue.size();
            }
        }
        return depth;
    }
}

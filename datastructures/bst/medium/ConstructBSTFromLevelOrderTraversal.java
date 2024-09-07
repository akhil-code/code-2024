package datastructures.bst.medium;

import datastructures.btrees.model.BinaryTreeNode;
import datastructures.btrees.traversals.bfs.LevelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBSTFromLevelOrderTraversal {
    public static void main(String[] args) {
        int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        BinaryTreeNode tree = constructTreeFromLevelOrder(arr);
        LevelOrderTraversal.levelOrderTraversal(tree);
    }

    public static BinaryTreeNode constructTreeFromLevelOrder(int[] levelOrder) {
        Queue<Pair> queue = new LinkedList<>();
        BinaryTreeNode root = new BinaryTreeNode(levelOrder[0]);
        queue.add(new Pair(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        int i = 1;
        while(!queue.isEmpty()) {
            final Pair currPair = queue.poll();
            // left node
            if(levelOrder[i] > currPair.min && levelOrder[i] < currPair.node.data) {
                currPair.node.left = new BinaryTreeNode(levelOrder[i]);
                i++;

                queue.add(new Pair(currPair.node.left, currPair.min, currPair.node.data));
            }
            if(i >= levelOrder.length) {
                break;
            }
            // right node
            if(levelOrder[i] > currPair.node.data && levelOrder[i] < currPair.max) {
                currPair.node.right = new BinaryTreeNode(levelOrder[i]);
                i++;
                queue.add(new Pair(currPair.node.right, currPair.node.data, currPair.max));
            }
            if(i >= levelOrder.length) {
                break;
            }
        }
        return root;
    }

    static class Pair{
        BinaryTreeNode node;
        int min;
        int max;

        public Pair(BinaryTreeNode node, int min, int max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "node=" + node +
                    ", min=" + min +
                    ", max=" + max +
                    '}';
        }
    }
}

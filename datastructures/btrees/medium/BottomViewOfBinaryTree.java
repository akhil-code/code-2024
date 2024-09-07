package datastructures.btrees.medium;

import datastructures.btrees.model.BinaryTreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BottomViewOfBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(20);
        root.left = new BinaryTreeNode(8);
        root.right = new BinaryTreeNode(22);
        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(3);
        root.right.left = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(25);
        root.left.right.left = new BinaryTreeNode(10);
        root.left.right.right = new BinaryTreeNode(14);
        System.out.println("Bottom view of the given binary tree :");
        printBottomView(root);
        
    }
    
    public static void printBottomView(BinaryTreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        // distance -> data
        Map<Integer, Integer> map = new HashMap<>();
        int minDist = 0, maxDist = 0;

        while(!queue.isEmpty()) {
            Pair currPair = queue.poll();
            map.put(currPair.dist, currPair.node.data);
            minDist = Math.min(minDist, currPair.dist);
            maxDist = Math.max(maxDist, currPair.dist);

            if(currPair.node.left != null) {
                queue.add(new Pair(currPair.node.left, currPair.dist - 1));
            }
            if(currPair.node.right != null) {
                queue.add(new Pair(currPair.node.right, currPair.dist + 1));
            }
        }

        for (int i = minDist; i <= maxDist; i++) {
            System.out.print(map.get(i) + " -> ");
        }
    }

    public static class Pair {
        BinaryTreeNode node;
        int dist;

        public Pair(BinaryTreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}

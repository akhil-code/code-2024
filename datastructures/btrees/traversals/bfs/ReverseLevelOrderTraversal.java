package datastructures.btrees.traversals.bfs;

import datastructures.btrees.BTreeUtil;
import datastructures.btrees.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode tree = BTreeUtil.createDummyTree();
        reverseLevelOrder(tree);
    }

    public static void reverseLevelOrder(BinaryTreeNode tree) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(tree);

        Stack<BinaryTreeNode> stack = new Stack<>();
        while(!queue.isEmpty()) {
            BinaryTreeNode currNode = queue.remove();
            stack.add(currNode);
            if(currNode.left != null) {
                queue.add(currNode.left);
            }
            if(currNode.right != null) {
                queue.add(currNode.right);
            }
        }

        while(!stack.isEmpty()) {
            BinaryTreeNode currNode = stack.pop();
            System.out.print(currNode.data + " -> ");
        }
    }

}

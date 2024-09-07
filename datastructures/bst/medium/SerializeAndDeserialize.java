package datastructures.bst.medium;

import datastructures.bst.Insertion;
import datastructures.btrees.model.BinaryTreeNode;
import datastructures.btrees.traversals.bfs.LevelOrderTraversal;
import datastructures.btrees.traversals.dfs.InorderTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SerializeAndDeserialize {
    public static void main(String[] args) {
        BinaryTreeNode actualTree = new BinaryTreeNode(1);
        actualTree = Insertion.insert(actualTree, 2);
        actualTree = Insertion.insert(actualTree, 2);
        actualTree = Insertion.insert(actualTree, 2);
        actualTree = Insertion.insert(actualTree, 2);
        actualTree = Insertion.insert(actualTree, 2);
        actualTree = Insertion.insert(actualTree, 2);

        LevelOrderTraversal.levelOrderTraversal(actualTree);
        List<Integer> serializedTree = serialize(actualTree);
        System.out.println(serializedTree);
        BinaryTreeNode deserializedTree = deserialize(serializedTree);
        LevelOrderTraversal.levelOrderTraversal(deserializedTree);
    }

    public static List<Integer> serialize(BinaryTreeNode tree) {
        List<Integer> serializedData = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.add(tree);
        while(!stack.isEmpty()) {
            BinaryTreeNode currNode = stack.pop();
            serializedData.add(currNode.data);
            if(currNode.right != null)
                stack.add(currNode.right);
            if(currNode.left != null)
                stack.add(currNode.left);
        }
        return serializedData;
    }

    public static BinaryTreeNode deserialize(List<Integer> serializedTreeList) {
        return ConstructBSTFromPreorder.constructBSTFromPreorder(serializedTreeList);
    }
}

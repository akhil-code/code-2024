package datastructures.btrees.model;

public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Node{");
        stringBuilder.append("d=" + data );
        if(left != null) {
            stringBuilder.append(", l=" + left);
        }
        if(right != null) {
            stringBuilder.append(", r=" + right);
        }
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}

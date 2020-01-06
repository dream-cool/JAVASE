package com.clt.it;

public class TreeNode {

    TreeNode left;
    TreeNode right;
    TreeNode parent;
    int element;

    public TreeNode(TreeNode left, TreeNode right, TreeNode parent, int element) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.element = element;
    }

    public TreeNode(int element) {
        this.element = element;
    }

    public TreeNode(TreeNode parent, int element) {
        this.parent = parent;
        this.element = element;
    }

    public TreeNode() {
    }
}

package com.clt.ET;

public class TreeNode<E> {

    TreeNode<E> left;
    TreeNode<E> right;
    TreeNode<E> parent;
    E element;

    public TreeNode(TreeNode<E> left, TreeNode<E> right, TreeNode<E> parent, E element) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.element = element;
    }

    public TreeNode(E element) {
        this.element = element;
    }

    public TreeNode() {
    }
}

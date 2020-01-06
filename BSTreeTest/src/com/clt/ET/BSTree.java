package com.clt.ET;

public class BSTree<E>{

    private TreeNode<E> root = null;


    private int size = 0;

    public BSTree() {
    }

    public BSTree(TreeNode<E> root, int size) {
        this.root = root;
        this.size = size;
    }

    public E getNodeData(TreeNode<E> tempnode){

        return null;
    }

    public TreeNode<E> getTreeNode(){

        return null;
    }


//    Comparable<? super E> e = (Comparable<? super E>) element;
    public void addTreeNode(E element){
        if (this.root == null){
            this.root = new TreeNode<E>(element);
            size = 1;
        } else {
            Comparable<? super E> e = (Comparable<? super E>) element;

            int cmp = e.compareTo(element);

            if (cmp > 0){

            }

        }
    }


    public boolean searchTreeNode(TreeNode<E> p, E element){
        Comparable<? super E> e = (Comparable<? super E>) element;
        TreeNode parent = root;
        TreeNode temp = null;

        while (parent != null){
            int cmp = e.compareTo(element);
            temp = parent;
            if (cmp > 0){
                parent = parent.right;
            } else if(cmp < 0){
                parent = parent.left;
            } else {
                p = parent;
                return true;
            }
        }
        p = temp;
        return false;
    }


    public boolean deleteTree(TreeNode<E> tempnode){
        return false;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

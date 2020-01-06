package com.clt.it;


public class BSTree{

    private TreeNode root = null;

    private int size = 0;

    public BSTree() {
    }

    public BSTree(TreeNode root, int size) {
        this.root = root;
        this.size = size;
    }

    public int getNodeData(TreeNode tempnode){
        return -1;
    }

    public TreeNode getTreeNode(){
        return null;
    }

    public boolean addTreeNode(int element){
        if (this.root == null){
            this.root = new TreeNode(element);
            size = 1;
            return true;
        } else {
            if(!searchTreeNode(element)){
                TreeNode parent = root;
                while (parent != null){
                    if (parent.element > element){
                        if (parent.left != null){
                            parent = parent.left;
                        } else {
                            parent.left = new TreeNode(parent, element);
                            size++;
                            return true;
                        }
                    } else if(parent.element < element){
                        if (parent.right != null){
                            parent = parent.right;
                        } else {
                            parent.right = new TreeNode(parent, element);
                            size++;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    public boolean searchTreeNode( int element){
        TreeNode parent = root;
        while (parent != null){
            if (parent.element > element){
                parent = parent.left;
            } else if(parent.element < element){
                parent = parent.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public void printTree(TreeNode tree){
        TreeNode parent = tree;
        if (parent == null){
            return;
        }
        System.out.print(parent.element+"->");
        printTree(parent.left);
        printTree(parent.right);
    }


    public boolean deleteTree(int element){
        if (root == null){
            return false;
        } else {
            if (searchTreeNode(element)){
                TreeNode current = root;
                while (current != null){
                    if (current.element > element){
                        current = current.left;
                    } else if(current.element < element){
                        current = current.right;
                    } else {
                        if (current.left == null){
                            if (current.parent.left == current){
                                current.parent.left = current.right;
                            } else {
                                current.parent.right = current.right;
                            }
                            return true;
                        }
                        if (current.right == null){
                            if (current.parent.left == current){
                                current.parent.left = current.left;
                            } else {
                                current.parent.right = current.left;
                            }
                            return true;
                        }
                        if (current.left != null && current.right != null){
                            TreeNode temp = current.left;
                            while (temp != null){
                                if (temp.right != null){
                                    temp = temp.right;
                                } else {
                                    current.element = temp.element;
                                    if (temp.parent.right == temp){
                                        temp.parent.right = temp.left;
                                    } else {
                                        temp.parent.left = temp.left;
                                    }
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

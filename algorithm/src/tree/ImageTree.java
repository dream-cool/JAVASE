package tree;

import secondday.TreeNode;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 20:23 2019/7/29
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class ImageTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(8);
        root.right.right = new TreeNode(6);
        System.out.println(isSymmetrical(root));
    }


    public static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return false;
        }
        return leftRitht(pRoot.left, pRoot.right);
    }

    public static boolean leftRitht(TreeNode left, TreeNode right){
        if (left == null){
            return right == null;
        }
        if (right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return leftRitht(left.right,right.left) && leftRitht(left.left,right.right);

    }
}

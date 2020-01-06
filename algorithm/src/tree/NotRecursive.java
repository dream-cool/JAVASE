package tree;

import secondday.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 9:02 2019/7/14
 */
public class NotRecursive {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(8);
        root.right.right = new TreeNode(7);
        BreadthRecursive(root);
        System.out.println();
    }

    //    非递归树的先序周游
    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            System.out.print(node.val + "\t");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    //    非递归树的中序周游
    public static void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.val + "\t");
                root = root.right;
            }
        }
    }

    //    非递归树的后序周游
    public static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
        }
    }

    //    树的广度遍历，即层次遍历
    public static void Breadth(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while (list.size() > 0) {
            TreeNode node = list.removeFirst();
            System.out.print(node.val+"\t");
            if (node.left != null) {
                list.addLast(node.left);
            }
            if (node.right != null) {
                list.addLast(node.right);
            }
        }
    }

    //层次遍历递归
    public static void BreadthRecursive(TreeNode root){
        if (root == null){
            return;
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        BreRecursive(root,1, list);
        System.out.println(list);
    }
    //层次遍历递归调用
    public static void BreRecursive(TreeNode root,int depth, ArrayList<ArrayList<Integer>> list){
        if (root == null){
            return;
        }
        if (depth > list.size()){
            list.add(new ArrayList<>());
        }
        list.get(depth - 1).add(root.val);
        BreRecursive(root.left,depth+1, list);
        BreRecursive(root.right,depth +1, list);
    }


    // 树的路径遍历
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private static ArrayList<Integer> ls = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> pathOrder(TreeNode root){
        if (root == null){
            return null;
        }
        ls.add(root.val);
        if (root.left == null && root.right == null){
            list.add(new ArrayList<>(ls));
        }
        pathOrder(root.left);
        pathOrder(root.right);
        ls.remove(ls.size()-1);
        return list;
    }

    public static ArrayList<ArrayList<Integer>> pathFind(TreeNode root, int target){
        if (root == null){
            return null;
        }
        ls.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null){
            list.add(new ArrayList<>(ls));
        }
        pathFind(root.left, target);
        pathFind(root.right, target);
        ls.remove(ls.size()-1);
        return list;
    }
}

package tree;


import secondday.Main5;
import secondday.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 21:37 2019/7/12
 */
public class PrintFromTopToBottom {
    private static List<Integer> list = new ArrayList<>();
    private static Map<Integer,Integer> map = new HashMap<>(16);
    static int count = 0;
    public static void main(String[] args) {
        int [] pre = {1,2,4,7,3,5,6,8};
        int [] in = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = Main5.reConstructBinaryTree(pre, in);
        System.out.println(PrintFromTopToBottom(treeNode));
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        if (root != null){
            System.out.print(root.val+"\t");
            map.put(root.val,count);
            if (root.left != null){
                PrintFromTopToBottom(root.left);
            }
            if (root.right != null){
                PrintFromTopToBottom(root.right);
            }
        }
        return (ArrayList<Integer>) list;
    }
}


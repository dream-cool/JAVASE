package secondday;



/**
 * @ Author   ：clt.
 * @ Date     ：Created in 19:21 2019/7/10
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Main5 {
    public static void main(String[] args) {
        int [] pre = {1,2,4,7,3,5,6,8};
        int [] in = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        System.out.println(1);
    }

    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root = new TreeNode(pre[0]);
        int index = 0;
        for (int i = 0; i < pre.length; i++) {
            if (root.val == in[i]){
                index = i;
                break;
            }
        }
        if (index <= pre.length - 1 && index != 0){
            int[] preLeft = new int[index];
            int[] inLeft = new int[index];
            for (int i = 0; i < index; i++) {
                inLeft[i] = in[i];
                preLeft[i] = pre[i+1];
            }
            root.left = reConstructBinaryTree(preLeft, inLeft);
        }
        if (index >= 0 && index != pre.length-1){
            int[] preRight = new int[pre.length-index-1];
            int[] inRight = new int[pre.length-index-1];
            for (int i = index+1,j = 0; i < pre.length; i++,j++) {
                inRight[j] = in[i];
                preRight[j] = pre[i];
            }
            root.right = reConstructBinaryTree(preRight, inRight);
        }
        return root;
    }
}


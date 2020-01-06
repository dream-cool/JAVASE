package link;

import java.util.LinkedList;
import java.util.Random;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:41 2019/7/30
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class LinkListK {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        int i = 2;
        for (ListNode temp = node; i <= 5 ;i++,temp = temp.next ) {
            int rand = new Random().nextInt(10);
            temp.next = new ListNode(i);
            System.out.println(i);
        }
        linkRecursive1(node,3);
        System.out.println();
    }
    public static ListNode FindKthToTail(ListNode head,int k) {
        LinkedList<ListNode> list = new LinkedList<>();
        linkRecursive(head,list);
        System.out.println(list);
        return list.get(k-1);
    }
    private static void linkRecursive(ListNode node, LinkedList list){
        if (node == null){
            return;
        }
        linkRecursive(node.next,list);
        list.addLast(node);
    }

    //递归算法找倒数第k个节点，不使用辅助空间
    private static int linkRecursive1(ListNode node, int k){
        if (node == null){
            return 0;
        }
        int x = linkRecursive1(node.next,k)+1;
        if (x == k){
            System.out.println(node);
        }
        return x;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

//    @Override
//    public String toString() {
//        return "" + val
//                ;
//    }

}
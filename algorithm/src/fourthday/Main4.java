package fourthday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 19:33 2019/7/5
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Main4 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        for (int i = 0; i < 5; i++) {
            ListNode node = new ListNode((int) (Math.random() * 10));
            node.next = node1;
            node1 = node;
        }
        System.out.println(node1);
        System.out.println(ReverseList(node1));
    }

    public static ListNode ReverseList(ListNode head) {
        ListNode temp = null;
        ListNode node = null;
        while (head != null){
            temp = head;
            head = head.next;
            temp.next = node;
            node = temp;
        }
        return node;
    }
}

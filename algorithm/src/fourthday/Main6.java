package fourthday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 20:40 2019/7/5
 */
public class Main6 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        for (int i = 0; i < 6; i++) {
            int a = (int) (Math.random() * 1);
            ListNode node = new ListNode(a);
            node.next = node1;
            node1 = node;
        }
        System.out.println(node1);
        System.out.println(deleteDuplication(node1));
    }

    public static ListNode deleteDuplication(ListNode pHead)
    {
        ListNode node = pHead;
        while(pHead.next.next != null){
            do {

                if (pHead.next.val == pHead.next.next.val){
                    pHead.next = pHead.next.next.next;
                }
                if (pHead.next == null || pHead.next.next== null){
                    break;
                }
            }while (pHead.next.val == pHead.next.next.val);
            if (pHead.next == null || pHead.next.next== null){
                break;
            }
            pHead = pHead.next;
        }
        if (node.val == node.next.val){
            node = node.next.next;
        }
        if(node == null){
            node = new ListNode(0);
        }
        return node;
    }
}

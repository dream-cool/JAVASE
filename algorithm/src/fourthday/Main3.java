package fourthday;


/**
 * @ Author   ：clt.
 * @ Date     ：Created in 16:07 2019/7/5
 * 描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Main3 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        for (int i = 0; i < 3; i++) {
            ListNode node = new ListNode((int) (Math.random() * 10));
            node.next = node1;
            node1 = node;
        }
        ListNode node2 = new ListNode(1);
        for (int i = 0; i < 3; i++) {
            ListNode node = new ListNode((int) (Math.random() * 10));
            node.next = node2;
            node2 = node;
        }
        System.out.println(Merge(node1,node2));
    }


    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode list = new ListNode(-1);
        ListNode temp = list;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                list.next = list1;
                list1 = list1.next;
                list = list.next;
            } else {
                list.next = list2;
                list2 = list2.next;
                list = list.next;
            }
        }
        if (list1 != null){
            list.next = list1;
        } else {
            list.next = list2;
        }
        return temp.next;
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
//        StringBuilder sb = new StringBuilder();
//        sb.append("{");
//        for (ListNode temp= this; temp != null ; temp = temp.next ){
//            sb.append(temp.val+",");
//        }
//        sb.setCharAt(sb.length()-1, '}');
//        return  sb.toString();
//    }
}
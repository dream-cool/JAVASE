package firstweek;

import java.util.ArrayList;

public class printListFromTailToHead {

    /**
     *    public class ListNode {
     *        int val;
     *        ListNode next = null;
     *
     *        ListNode(int val) {
     *            this.val = val;
     *        }
     *    }
     *
     */

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> templist = new ArrayList<>();
        ArrayList<Integer> alist = new ArrayList<>();
        while (listNode != null){
            templist.add(listNode.val);
            listNode = listNode.next;
        }
        int i = templist.size()-1;
        while (i >= 0){
            alist.add(templist.get(i));
            i--;
        }
        return alist;
    }
}

class ListNode {
     int val;
     ListNode next = null;

     ListNode(int val) {
         this.val = val;
     }
}


package review;

import review.base.ListNode;

public class Fzlb {

    public static void main(String[] args) {

    }

    public static ListNode fzlb(ListNode head){
        if (head==null){
            return null;
        }
        ListNode pre = null;
        ListNode node = head;
        while (node!=null){
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
    }
}

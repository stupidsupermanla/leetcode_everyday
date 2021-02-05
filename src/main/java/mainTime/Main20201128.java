package mainTime;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20201128 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
//        System.out.println(maxRepeating("aaa", "a"));
//        ListNode list1 = new ListNode(0);
//        ListNode list2 = new ListNode(1);
//        ListNode list3 = new ListNode(2);
//        ListNode list4 = new ListNode(3);
//        ListNode list5 = new ListNode(4);
//        list1.next = list2;
//        list2.next = list3;
//        list3.next = list4;
//        list4.next = list5;
//        ListNode l1 = new ListNode(10000);
//        ListNode l2 = new ListNode(10001);
//        ListNode l3 = new ListNode(10002);
//        l1.next = l2;
//        l2.next = l3;
////        ListNode l4 = new ListNode(3);
////        ListNode l5 = new ListNode(4);
////        ListNode l6 = new ListNode(5);
//
//        ListNode listNode = mergeInBetween(list1, 2, 3, l1);
//
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }

        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);
        q.pushBack(2);
        q.pushMiddle(3);
        q.pushMiddle(4);
        q.pushMiddle(5);
        System.out.println(q.popFront());
        System.out.println(q.popMiddle());
        System.out.println(q.popMiddle());
        System.out.println(q.popMiddle());
        System.out.println(q.popMiddle());
        System.out.println(q.popBack());
        System.out.println(q.popFront());

    }


    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode lasta = list1;
        ListNode lastb = list1;
        for (int i = 0; i < a - 1; i++) {
            lasta = lasta.next;
            lastb = lastb.next;
        }
        for (int i = 0; i < b - a + 1; i++) {
            lastb = lastb.next;
        }
        if (lastb.next == null) {
            lasta.next = list2;
            return list1;
        }
        ListNode last2 = list2;
        while (last2.next != null) {
            last2 = last2.next;
        }
        lasta.next = list2;
        last2.next = lastb.next;
        return list1;

    }


    public static int maxRepeating(String sequence, String word) {
        int count = 0;
        int wLen = word.length();
        if (wLen > sequence.length()) {
            return count;
        }
        while (sequence.contains(word)) {
            int t = 1;
            int i = sequence.indexOf(word);
            sequence = sequence.substring(i + wLen);
            while (sequence.length() >= wLen && sequence.substring(0, wLen).equals(word)) {
                sequence = sequence.substring(wLen);
                t++;
            }
            count = Math.max(count, t);
        }
        return count;
    }

}

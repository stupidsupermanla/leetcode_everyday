//对链表进行插入排序。 
//
// 
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。 
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。 
//
// 
//
// 插入排序算法： 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2： 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
// 
// Related Topics 排序 链表


package leetcode.leetcode.editor.cn;

/**
 * Java：对链表进行插入排序
 */
public class P147InsertionSortList {
    public static void main(String[] args) {
        Solution solution = new P147InsertionSortList().new Solution();
        // TO TEST
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(7);
        l6.next = l5;
        l5.next = l4;
        l4.next = l3;
        l3.next = l7;
        l7.next = l2;
        l2.next = l1;

//        l1.next=l6;
//        l6.next=l3;
//        l3.next=l4;
//        l4.next=l2;
//        l2.next=l5;
//        l5.next=l1;
        ListNode listNode = solution.insertionSortList(l6);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode node = head;
            ListNode temp = head;
            int last = head.val;
            while (node.next != null) {
                ListNode pre = node;
                node = node.next;
                if (node.val >= last) {
                    last=node.val;
                    continue;
                }
                if (node.val < temp.val) {
                    pre.next = node.next;
                    node.next = head;
                    head = node;
                    node=pre;
                    temp = head;
                    continue;
                }
                while (node.val > temp.next.val) {
                    temp = temp.next;
                }
                ListNode next = temp.next;
                pre.next = node.next;
                node.next = next;
                temp.next = node;
                node = pre;
                temp = head;
            }
            return head;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
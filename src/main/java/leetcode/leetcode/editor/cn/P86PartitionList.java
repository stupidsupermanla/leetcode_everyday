//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例： 
//
// 
//输入：head = 1->4->3->2->5->2, x = 3
//输出：1->2->2->4->3->5
// 
// Related Topics 链表 双指针


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：分隔链表
 */
public class P86PartitionList {
    public static void main(String[] args) {
        Solution solution = new P86PartitionList().new Solution();
        // TO TEST
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(4);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(5);
        ListNode head5 = new ListNode(2);
//        head.next = head1;
//        head1.next = head2;
//        head2.next = head3;
//        head3.next = head4;
//        head4.next = head5;
        ListNode partition = solution.partition(head, 1);
        while (partition != null) {
            System.out.println(partition.val);
            partition = partition.next;
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
        public ListNode partition(ListNode head, int x) {
            if (head == null) {
                return null;
            }
            List<Integer> small = new ArrayList<>();
            List<Integer> big = new ArrayList<>();
            while (head != null) {
                if (head.val < x) {
                    small.add(head.val);
                } else {
                    big.add(head.val);
                }
                head = head.next;
            }
            ListNode result;
            ListNode pre;
            ListNode temp;
            if (small.isEmpty()) {
                result = new ListNode(big.get(0));
                big.remove(0);
            } else {
                result = new ListNode(small.get(0));
                small.remove(0);
            }
            pre = result;
            while (!small.isEmpty()) {
                temp = new ListNode(small.get(0));
                small.remove(0);
                pre.next = temp;
                pre = temp;
            }
            while (!big.isEmpty()) {
                temp = new ListNode(big.get(0));
                big.remove(0);
                pre.next = temp;
                pre = temp;
            }
            return result;
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
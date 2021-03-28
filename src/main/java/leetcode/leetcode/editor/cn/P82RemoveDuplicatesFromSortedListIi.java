//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表


package leetcode.leetcode.editor.cn;

/**
 * Java：删除排序链表中的重复元素 II
 */
public class P82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
        // TO TEST
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
        ListNode node = solution.deleteDuplicates(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            boolean isSetHead = false;
            ListNode pre = null;
            ListNode temp = null;
            Integer cur = null;
            int count = 0;
            ListNode result = null;
            while (head != null) {
                if (cur == null) {
                    temp =new ListNode(head.val);;
                    cur = head.val;
                    count++;
                } else {
                    if (head.val != cur) {
                        if (count > 1) {

                        } else {
                            if (!isSetHead) {
                                pre = temp;
                                result = temp;
                                isSetHead = true;
                            } else {
                                pre.next = temp;
                                pre = temp;
                            }
                        }
                        cur = head.val;
                        temp = new ListNode(cur);
                        count = 1;
                    } else {
                        count++;
                    }
                }
                head = head.next;
            }
            if (count<=1){
                if (!isSetHead) {
                    result = temp;
                } else {
                    pre.next = temp;
                }
            }
            return result;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
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
}
//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表


package leetcode.leetcode.editor.cn;

/**
 * Java：有序链表转换二叉搜索树
 */
public class P109ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P109ConvertSortedListToBinarySearchTree().new Solution();
        // TO TEST
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        ListNode list6 = new ListNode(6);
        ListNode list7 = new ListNode(7);
        ListNode list8 = new ListNode(8);
        list1.next = list2;
        list2.next = list3;
//        list3.next = list4;
//        list4.next = list5;
//        list5.next = list6;
//        list6.next = list7;
//        list7.next = list8;
        TreeNode node = solution.sortedListToBST(list1);
        System.out.println(node);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if(head==null){
                return null;
            }
            ListNode middle = getMiddle(head);
            TreeNode node = new TreeNode(middle.val);
            if (middle==head){
                return node;
            }
            bst(head, node, true);
            bst(middle.next, node, false);
            return node;
        }

        private void bst(ListNode head, TreeNode node, boolean isLeft) {
            if (head == null) {
                return;
            }
            ListNode middle = getMiddle(head);
            TreeNode newNode = new TreeNode(middle.val);
            if (isLeft) {
                node.left = newNode;
            } else {
                node.right = newNode;
            }
            if (middle == head) {
                return;
            }
            bst(head, newNode, true);
            bst(middle.next, newNode, false);
        }

        private ListNode getMiddle(ListNode head) {
            ListNode dub = head;
            ListNode pre = head;
            while (dub != null) {
                if (dub.next != null) {
                    pre = head;
                    head = head.next;
                    dub = dub.next.next;
                } else {
                    break;
                }
            }
            pre.next = null;
            return head;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class ListNode {
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

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
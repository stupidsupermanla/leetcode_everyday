//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树


package leetcode.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Java：翻转二叉树
 */
public class P226InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P226InvertBinaryTree().new Solution();
        // TO TEST
        TreeNode root=new TreeNode(0);
        TreeNode head1=new TreeNode(1);
        TreeNode head2=new TreeNode(2);
        TreeNode head3=new TreeNode(3);
        TreeNode head4=new TreeNode(4);
        TreeNode head5=new TreeNode(5);
        TreeNode head6=new TreeNode(6);
        TreeNode head7=new TreeNode(7);
        TreeNode head8=new TreeNode(8);
        TreeNode head9=new TreeNode(9);
        root.left=head1;
        root.right=head2;
        head1.left=head3;
        head1.right=head4;
        head2.left=head5;
        head2.right=head6;
        TreeNode treeNode = solution.invertTree(root);
        System.out.println(treeNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return root;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            return root;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
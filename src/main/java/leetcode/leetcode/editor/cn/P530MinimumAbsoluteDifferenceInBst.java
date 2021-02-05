//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：二叉搜索树的最小绝对差
 */
public class P530MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new P530MinimumAbsoluteDifferenceInBst().new Solution();
        // TO TEST
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
        List<Integer> list = new ArrayList<>();

        public int getMinimumDifference(TreeNode root) {
            mid(root);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < list.size() - 1; i++) {
                int first = list.get(i);
                int second = list.get(i + 1);
                min = Math.min(min, second - first);
            }
            return min;
        }

        private void mid(TreeNode root) {
            if (root == null) {
                return;
            }
            mid(root.left);
            list.add(root.val);
            mid(root.right);
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
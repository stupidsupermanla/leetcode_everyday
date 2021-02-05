//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：路径总和 II
 */
public class P113PathSumIi {
    public static void main(String[] args) {
        Solution solution = new P113PathSumIi().new Solution();
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
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            dfs(root, sum);
            return result;
        }

        private void dfs(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            temp.add(root.val);
            sum -= root.val;
            if (root.left == null && root.right == null && sum == 0) {
                result.add(new ArrayList<>(temp));
                return;
            }
            dfs(root.left, sum);
            dfs(root.right, sum);
            temp.remove(temp.size() - 1);
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
//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,2,5,null,null,5,7]
//输出：5
//解释：最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2： 
//
// 
//输入：root = [2,2,2]
//输出：-1
//解释：最小的值是 2, 但是不存在第二小的值。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 25] 内 
// 1 <= Node.val <= 231 - 1 
// 对于树中每个节点 root.val == min(root.left.val, root.right.val) 
// 
// Related Topics 树 深度优先搜索 二叉树


package leetcode.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Java：二叉树中第二小的节点
 */
public class P671SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {
        Solution solution = new P671SecondMinimumNodeInABinaryTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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
        public int findSecondMinimumValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean flag = true;
            int min = root.val;
            int max = Integer.MAX_VALUE;
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll.left != null && poll.right != null) {
                    int cMax = Math.max(poll.left.val, poll.right.val);
                    if (min != cMax && max > cMax) {
                        max = cMax;
                        flag = false;
                    }
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            return flag ? -1 : max;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
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
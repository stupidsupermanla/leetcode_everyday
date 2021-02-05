//给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节
//点值之和。 
//
// 
//
// 例如： 
//
// 输入: 原始二叉搜索树:
//              5
//            /   \
//           2     13
//
//输出: 转换为累加树:
//             18
//            /   \
//          20     13
// 
//
// 
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-s
//um-tree/ 相同 
// Related Topics 树


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：把二叉搜索树转换为累加树
 */
public class P538ConvertBstToGreaterTree {
    public static void main(String[] args) {
        Solution solution = new P538ConvertBstToGreaterTree().new Solution();
        // TO TEST
        TreeNode root=new TreeNode(4);
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(0);
        TreeNode t3=new TreeNode(2);
        TreeNode t4=new TreeNode(3);
        TreeNode t5=new TreeNode(6);
        TreeNode t6=new TreeNode(5);
        TreeNode t7=new TreeNode(7);
        TreeNode t8=new TreeNode(8);
        root.left=t1;
        root.right=t5;
        t1.left=t2;
        t1.right=t3;
        t3.right=t4;
        t5.left=t6;
        t5.right=t7;
        t7.right=t8;
        solution.convertBST(root);
        System.out.println();

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
        List<TreeNode> list = new ArrayList<>();

        public TreeNode convertBST(TreeNode root) {
            midOrderRe(root);
            int temp = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                TreeNode treeNode = list.get(i);
                temp += treeNode.val;
                treeNode.val = temp;
            }
            return root;
        }

        public void midOrderRe(TreeNode biTree) {//中序遍历递归实现
            if (biTree == null) {
                return;
            } else {
                midOrderRe(biTree.left);
                list.add(biTree);
                midOrderRe(biTree.right);
            }
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
//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树


package leetcode.leetcode.editor.cn;

import java.util.*;

/**
 * Java：二叉树中所有距离为 K 的结点
 */
public class P863AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P863AllNodesDistanceKInBinaryTree().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(0);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n4.left = n5;
        n4.right = n6;
        n2.left = n7;
        List<Integer> list = solution.distanceK(root, n1, 2);
        for (Integer integer : list) {
            System.out.print(integer + ",");
        }
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
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            if (k == 0) {
                return Collections.singletonList(target.val);
            }
            Map<Integer, Integer> upMap = new HashMap<>();
            Map<Integer, Set<Integer>> downMap = new HashMap<>();
            Set<Integer> result = new HashSet<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    upMap.put(poll.left.val, poll.val);
                    Set<Integer> set = downMap.getOrDefault(poll.val, new HashSet<>());
                    set.add(poll.left.val);
                    downMap.put(poll.val, set);
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    upMap.put(poll.right.val, poll.val);
                    Set<Integer> set = downMap.getOrDefault(poll.val, new HashSet<>());
                    set.add(poll.right.val);
                    downMap.put(poll.val, set);
                    queue.add(poll.right);
                }
            }
            Set<Integer> downSet = new HashSet<>();
            downSet.add(target.val);
            int up = target.val;
            int from = up;
            int down;
            boolean isOne = true;
            while (k > 0) {
                Set<Integer> dsToMin = new HashSet<>(downSet);
                Set<Integer> dsToPlus = new HashSet<>();
                for (Integer key : downSet) {
                    if (downMap.containsKey(key)) {
                        dsToPlus.addAll(downMap.get(key));
                    }
                }
                downSet.removeAll(dsToMin);
                downSet.addAll(dsToPlus);
                if (isOne) {
                    if (upMap.containsKey(up)) {
                        from = up;
                        up = upMap.get(from);

                        down = k-1;
                        Set<Integer> downSet2 = new HashSet<>();
                        downSet2.add(up);
                        while (down > 0) {
                            Set<Integer> dsToMin2 = new HashSet<>(downSet2);
                            Set<Integer> dsToPlus2 = new HashSet<>();
                            for (Integer key : downSet2) {
                                if (downMap.containsKey(key)) {
                                    dsToPlus2.addAll(downMap.get(key));
                                }
                            }
                            downSet2.removeAll(dsToMin2);
                            downSet2.addAll(dsToPlus2);
                            downSet2.remove(from);
                            down--;
                        }
                        result.addAll(downSet2);
                    } else {
                        isOne = false;
                    }
                }
                k--;
            }
            if (isOne) {
                result.add(up);
            }
            result.addAll(downSet);
            return new ArrayList<>(result);
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
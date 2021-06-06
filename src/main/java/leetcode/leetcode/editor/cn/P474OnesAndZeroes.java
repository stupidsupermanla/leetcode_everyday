//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。 
//
// 
// 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。 
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 
//n 的值 3 。
// 
//
// 示例 2： 
//
// 
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] 仅由 '0' 和 '1' 组成 
// 1 <= m, n <= 100 
// 
// Related Topics 动态规划


package leetcode.leetcode.editor.cn;

/**
 * Java：一和零
 */
public class P474OnesAndZeroes {
    public static void main(String[] args) {
        Solution solution = new P474OnesAndZeroes().new Solution();
        // TO TEST
        System.out.println(solution.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int len = strs.length;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i < len; i++) {
                String str = strs[i];
                int c0 = 0;
                int c1 = 0;
                for (int o = 0; o < str.length(); o++) {
                    if (str.charAt(o) == '1') {
                        c1++;
                    } else {
                        c0++;
                    }
                }
                for (int j = m; j >= c0; j--) {
                    for (int k = n; k >= c1; k--) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - c0][k - c1] + 1);
                    }
                }
            }
            return dp[m][n];
        }
//leetcode submit region end(Prohibit modification and deletion)

    }
}
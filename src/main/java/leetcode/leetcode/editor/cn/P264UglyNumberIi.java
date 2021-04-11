//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 堆 数学 动态规划


package leetcode.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Java：丑数 II
 */
public class P264UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new P264UglyNumberIi().new Solution();
        // TO TEST
        System.out.println(solution.nthUglyNumber(1407));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            TreeSet<Long> set = new TreeSet<>();
            int pNum=1;
            set.add(1L);
            int[] nums = new int[]{2, 3, 5};
            while (pNum < n) {
                Long integer = set.pollFirst();
                pNum++;
                for (int i : nums) {
                    set.add(integer * i);
                }
            }
            return set.pollFirst().intValue();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
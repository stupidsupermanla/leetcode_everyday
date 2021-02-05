//我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。 
//
// 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。 
//
// 
//
// 示例 1： 
//
// 输出：low = 100, high = 300
//输出：[123,234]
// 
//
// 示例 2： 
//
// 输出：low = 1000, high = 13000
//输出：[1234,2345,3456,4567,5678,6789,12345]
// 
//
// 
//
// 提示： 
//
// 
// 10 <= low <= high <= 10^9 
// 
// Related Topics 回溯算法


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：顺次数
 */
public class P1291SequentialDigits {
    public static void main(String[] args) {
        Solution solution = new P1291SequentialDigits().new Solution();
        // TO TEST
        List<Integer> list = solution.sequentialDigits(1000, 13000);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> sequentialDigits(int low, int high) {
            int[] all = new int[]{12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789,
                    12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789,
                    12345678, 23456789, 123456789};
            List<Integer> result = new ArrayList<>();
            for (int i : all) {
                if (i < low) {
                    continue;
                }
                if (i > high) {
                    return result;
                }
                result.add(i);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
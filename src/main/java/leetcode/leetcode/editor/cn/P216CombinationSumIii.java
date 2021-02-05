//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：组合总和 III
 */
public class P216CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new P216CombinationSumIii().new Solution();
        // TO TEST
        List<List<Integer>> lists = solution.combinationSum3(3, 15);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int ak, an;

        public List<List<Integer>> combinationSum3(int k, int n) {
            ak = k;
            an = n;
            getSum(1, an);
            return result;
        }

        private void getSum(int i, int target) {
            if (i > 10) {
                return;
            }
            if (temp.size() > ak) {
                return;
            }
            if (target == 0 && temp.size() == ak) {
                result.add(new ArrayList<>(temp));
                return;
            }
            if (target < 0) {
                return;
            }
            while (target - i >= 0) {
                temp.add(i);
                getSum(i + 1, target - i);
                temp.remove(temp.size() - 1);
                i++;
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
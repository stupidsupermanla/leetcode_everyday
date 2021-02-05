//给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 num
//s[i] 的元素的数量。 
//
// 示例: 
//
// 输入: [5,2,6,1]
//输出: [2,1,1,0] 
//解释:
//5 的右侧有 2 个更小的元素 (2 和 1).
//2 的右侧仅有 1 个更小的元素 (1).
//6 的右侧有 1 个更小的元素 (1).
//1 的右侧有 0 个更小的元素.
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：计算右侧小于当前元素的个数
 */
public class P315CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        Solution solution = new P315CountOfSmallerNumbersAfterSelf().new Solution();
        // TO TEST
        List<Integer> integers = solution.countSmaller(new int[]{5, 2, 6, 1});
        for (Integer integer : integers) {
            System.out.print(integer + ",");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> result = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                result.add(0);
                int temp = nums[i];
                for (int j = 0; j < i; j++) {
                    if (nums[j] > temp) {
                        Integer integer = result.get(j);
                        integer++;
                        result.set(j, integer);
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window


package leetcode.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：滑动窗口最大值
 */
public class P239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        // TO TEST
//        [9,10,9,-7,-4,-8,2,-6]
//        5
//        [-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7]
//        7
        int[] ints = solution.maxSlidingWindow(new int[]{-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7}, 7);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (k == 1) {
                return nums;
            }
            int len = nums.length;
            int[] result = new int[len - k + 1];
            List<Pair<Integer, Integer>> list = new ArrayList<>();
            int max = nums[0];
            list.add(new Pair<>(max, 0));
            for (int j = 1; j < k; j++) {
                if (nums[j] >= max) {
                    list.clear();
                    max = nums[j];
                }
                list.add(new Pair<>(nums[j], j));
            }
            result[0] = max;
            for (int i = 1; i < len - k + 1; i++) {
                int temp = nums[i + k - 1];
                Pair<Integer, Integer> first = list.get(0);
                if (first.getValue() < i) {
                    if (first.getKey() <= temp) {
                        list.clear();
                        max = temp;
                    } else {
                        list.remove(0);
                        max = temp;
                        int c = list.size();
                        for (int j = 0; j < list.size(); j++) {
                            if (list.get(j).getKey() > max) {
                                max = list.get(j).getKey();
                                c = j;
                            }
                        }
                        for (int j = 0; j < c; j++) {
                            list.remove(0);
                        }
                    }
                } else {
                    if (first.getKey() <= temp) {
                        list.clear();
                        max = temp;
                    }
                }
                list.add(new Pair<>(temp, i + k - 1));
                result[i] = max;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
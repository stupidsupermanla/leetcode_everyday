//在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0
//。 
//
// 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：A = [0,1,0], K = 1
//输出：2
//解释：先翻转 A[0]，然后翻转 A[2]。
// 
//
// 示例 2： 
//
// 
//输入：A = [1,1,0], K = 2
//输出：-1
//解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
// 
//
// 示例 3： 
//
// 
//输入：A = [0,0,0,1,0,1,1,0], K = 3
//输出：3
//解释：
//翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
//翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
//翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 30000 
// 1 <= K <= A.length 
// 
// Related Topics 贪心算法 Sliding Window


package leetcode.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Java：K 连续位的最小翻转次数
 */
public class P995MinimumNumberOfKConsecutiveBitFlips {
    public static void main(String[] args) {
        Solution solution = new P995MinimumNumberOfKConsecutiveBitFlips().new Solution();
        // TO TEST
        System.out.println(solution.minKBitFlips(new int[]{0,1,1, 0, 0, 1, 0, 0}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minKBitFlips(int[] A, int K) {
            int result = 0;
            int len = A.length;
            //存放翻转队列
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                //翻转队列元素大于当前元素，出队
                if (!queue.isEmpty() && queue.peek() == i) {
                    queue.poll();
                }
                //当前值=原有值+队列长度（翻转次数）
                if (A[i] == 0 && queue.size() % 2 == 0 || A[i] == 1 && queue.size() % 2 == 1) {
                    if (i + K > len) {
                        return -1;
                    }
                    queue.add(i + K);
                    result++;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
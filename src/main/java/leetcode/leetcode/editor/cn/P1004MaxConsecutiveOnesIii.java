//给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。 
//
// 返回仅包含 1 的最长（连续）子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释： 
//[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：
//[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20000 
// 0 <= K <= A.length 
// A[i] 为 0 或 1 
// 
// Related Topics 双指针 Sliding Window 
// 👍 179 👎 0


package leetcode.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：最大连续1的个数 III
public class P1004MaxConsecutiveOnesIii {
    public static void main(String[] args) {
        Solution solution = new P1004MaxConsecutiveOnesIii().new Solution();
        // TO TEST
        System.out.println(solution.longestOnes(new int[]{0,0,1,1,1,0,1}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] A, int K) {
            int len = A.length;
            int max =0;
            int count=0;
            Queue<Integer> queue=new LinkedList<>();
            for (int i = 0; i < len; i++) {
                int num = A[i];
                if (num==1){
                    queue.add(1);
                }else {
                    if (K==0){
                        max=Math.max(max,queue.size());
                        queue.clear();
                        continue;
                    }
                    if (count==K){
                        max=Math.max(max,queue.size());
                        while (queue.size()>0 && queue.poll()!=0){

                        }
                        queue.add(0);
                    }else {
                        queue.add(0);
                        count++;
                    }
                }
            }
            max=Math.max(max,queue.size());
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
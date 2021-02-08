//当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组： 
//
// 
// 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]； 
// 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。 
// 
//
// 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。 
//
// 返回 A 的最大湍流子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：[9,4,2,10,7,8,8,1,9]
//输出：5
//解释：(A[1] > A[2] < A[3] > A[4] < A[5])
// 
//
// 示例 2： 
//
// 输入：[4,8,12,16]
//输出：2
// 
//
// 示例 3： 
//
// 输入：[100]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 40000 
// 0 <= A[i] <= 10^9 
// 
// Related Topics 数组 动态规划 Sliding Window


package leetcode.leetcode.editor.cn;

/**
 * Java：最长湍流子数组
 */
public class P978LongestTurbulentSubarray {
    public static void main(String[] args) {
        Solution solution = new P978LongestTurbulentSubarray().new Solution();
        // TO TEST
        System.out.println(solution.maxTurbulenceSize(new int[]{9,2,3,2,4,4,4,4,5,6,2,7,3,8,9}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxTurbulenceSize(int[] arr) {
            int len = arr.length;
            if (len < 2) {
                return len;
            }
//            int left = 0, right = 1;
//            int max = 2;
//            boolean flag, targetFlag;//true > , false <
//            flag = arr[right] > arr[left];
//            targetFlag = !flag;
//            while (right < len - 1) {
//                boolean tempFlag = arr[right + 1] > arr[right];
//                if (targetFlag == tempFlag) {
//                    targetFlag=!targetFlag;
//                }else {
//                    int l =right-left;
//                    max = Math.max(max,l);
//                    left=right;
//                }
//                right++;
//            }
//            int l =right-left;
//            max = Math.max(max,l);
//            return max;
            Boolean targetFlag = null;
            int max =1;
            int count = 1;
            for (int i = 0; i < len-1; i++) {
                if (arr[i + 1] == arr[i]){
                    max = Math.max(max,count);
                    count = 1;
                    continue;
                }
                boolean tempFlag = arr[i + 1] > arr[i];
                if (targetFlag == null){
                    targetFlag = !tempFlag;
                    count++;
                }else {
                    if (targetFlag==tempFlag) {
                        count++;
                        targetFlag=!targetFlag;
                    }else {
                        max = Math.max(max,count);
                        count = 2;
                    }
                }
            }
            max = Math.max(max,count);
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
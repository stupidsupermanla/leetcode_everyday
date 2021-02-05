//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 
//
// 注意: 
//
// 
// num 的长度小于 10002 且 ≥ k。 
// num 不会包含任何前导零。 
// 
//
// 示例 1 : 
//
// 
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
// 
//
// 示例 2 : 
//
// 
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 : 
//
// 
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
// 
// Related Topics 栈 贪心算法


package leetcode.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Java：移掉K位数字
 */
public class P402RemoveKDigits {
    public static void main(String[] args) {
        Solution solution = new P402RemoveKDigits().new Solution();
        // TO TEST
        System.out.println(solution.removeKdigits("1432219", 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            if (k == num.length()) {
                return "0";
            }
            if (k == 0) {
                return num;
            }
            int l = k;
            char[] chars = num.toCharArray();
            char[] result = new char[num.length()];
            Arrays.fill(result, '0');
            result[0] = chars[0];
            int i = 1;
            int index = 0;
            while (i < num.length()) {
                while (k > 0 && index >= 0 && chars[i] < result[index]) {
                    k--;
                    result[index] = '0';
                    index--;
                }
                result[++index] = chars[i];
                i++;
                if (k == 0) {
                    break;
                }
            }
            String r = "";
            for (int j = 0; j < i - l + k; j++) {
                r += result[j];
            }
            if (k == 0) {
                r += num.substring(i);
            } else {
                r=r.substring(0,r.length()-k);
            }
            while (r.length() > 0 && r.charAt(0) == '0') {
                r = r.substring(1);
            }
            return r.length() > 0 ? r : "0";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
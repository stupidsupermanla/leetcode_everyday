//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串


package leetcode.leetcode.editor.cn;

/**
 * Java：字符串相加
 */
public class P415AddStrings {
    public static void main(String[] args) {
        Solution solution = new P415AddStrings().new Solution();
        // TO TEST
        System.out.println(solution.addStrings("", "789"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            char[] num1s = num1.toCharArray();
            char[] num2s = num2.toCharArray();
            int len1 = num1s.length;
            int len2 = num2s.length;
            int len = Math.max(len1, len2);
            String result = "";
            int addOne = 0;
            for (int i = 1; i <= len; i++) {
                int n1 = 0;
                int n2 = 0;
                if (i <= len1) {
                    n1 = num1s[len1 - i] - '0';
                }
                if (i <= len2) {
                    n2 = num2s[len2 - i] - '0';
                }
                int temp = n1 + n2 + addOne;
                if (temp >= 10) {
                    addOne = 1;
                    temp -= 10;
                } else {
                    addOne = 0;
                }
                result = temp + result;
            }
            if (addOne == 1) {
                result = "1" + result;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
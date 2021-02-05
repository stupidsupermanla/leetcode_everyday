//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串


package leetcode.leetcode.editor.cn;

/**
 * Java：字符串相乘
 */
public class P43MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new P43MultiplyStrings().new Solution();
        // TO TEST
        System.out.println(solution.multiply("123", "30"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            int len1 = num1.length();
            int len2 = num2.length();
            int[] result = new int[len1 + len2];
            int lastPosition = len1 + len2 - 1;
            char[] char1 = num1.toCharArray();
            char[] char2 = num2.toCharArray();
            for (int i = 1; i <= len2; i++) {
                char c2 = char2[len2 - i];
                int n2 = c2 - '0';
                for (int j = 1; j <= len1; j++) {
                    char c1 = char1[len1 - j];
                    int n1 = c1 - '0';
                    int temp = n1 * n2;
                    if (temp >= 10) {
                        add(result, lastPosition + 2 - i - j, temp % 10);
                        add(result, lastPosition + 2 - i - j - 1, temp / 10);
                    } else {
                        add(result, lastPosition + 2 - i - j, temp);
                    }
                }
            }
            String re = "";
            boolean flag = true;
            for (int i : result) {
                if (i == 0 && flag) {
                    continue;
                } else {
                    flag = false;
                }
                re += i;
            }
            if ("".equals(re)) {
                re = "0";
            }
            return re;
        }

        private void add(int[] result, int position, int num) {
            int i = result[position] + num;
            if (i >= 10) {
                result[position] = i % 10;
                add(result, position - 1, 1);
            } else {
                result[position] = i;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
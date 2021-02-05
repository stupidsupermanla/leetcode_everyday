//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 深度优先搜索


package leetcode.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Java：字符串解码
 */
public class P394DecodeString {
    public static void main(String[] args) {
        Solution solution = new P394DecodeString().new Solution();
        // TO TEST
        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<Character> cSet = new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

        public String decodeString(String s) {
            while (s.contains("[")) {
                s = replaceString(s);
            }
            return s;
        }

        private String replaceString(String s) {
            Stack<Integer> stack = new Stack<>();
            String[] ss = s.split("");
            int len = ss.length;
            String s1 = "";
            String s2 = "";
            String s3 = "";
            for (int i = 0; i < len; i++) {
                if ("[".equals(ss[i])) {
                    stack.push(i);
                }
                if ("]".equals(ss[i])) {
                    Integer start = stack.pop();
                    int pt = start - 1;
                    while (pt >= 0 && cSet.contains(s.charAt(pt))) {
                        pt--;
                    }
                    if (pt >= 0) {
                        s1 = s.substring(0, pt+1);
                    }
                    String temp = s.substring(start + 1, i);
                    s3 = s.substring(i + 1);
                    int times = Integer.parseInt(s.substring(pt + 1, start));
                    for (int j = 0; j < times; j++) {
                        s2 += temp;
                    }
                    break;
                }
            }
            return s1 + s2 + s3;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
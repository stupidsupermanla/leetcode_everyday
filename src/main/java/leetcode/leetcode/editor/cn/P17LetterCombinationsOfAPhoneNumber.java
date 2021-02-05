//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：电话号码的字母组合
 */
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
        List<String> strings = solution.letterCombinations("2");
        strings.forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result = new ArrayList<>();
        int len;
        String[] ss;

        public List<String> letterCombinations(String digits) {
            if (digits.equals("")) {
                return result;
            }
            ss = digits.split("");
            len = ss.length;
            add(0, "");
            return result;
        }

        private void add(int i, String temp) {
            if (i >= len) {
                result.add(temp);
                return;
            }
            String[] s = getStrings(ss[i]);
            for (String s1 : s) {
                temp += s1;
                add(i + 1, temp);
                temp = temp.substring(0, i);
            }
        }

        private String[] getStrings(String s) {
            switch (s) {
                case "2":
                    return new String[]{"a", "b", "c"};

                case "3":
                    return new String[]{"d", "e", "f"};

                case "4":
                    return new String[]{"g", "h", "i"};

                case "5":
                    return new String[]{"j", "k", "l"};

                case "6":
                    return new String[]{"m", "n", "o"};

                case "7":
                    return new String[]{"p", "q", "r", "s"};

                case "8":
                    return new String[]{"t", "u", "v"};

                case "9":
                    return new String[]{"w", "x", "y", "z"};

                default:
                    return null;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
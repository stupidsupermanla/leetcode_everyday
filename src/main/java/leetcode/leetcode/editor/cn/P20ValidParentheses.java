//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


package leetcode.leetcode.editor.cn;

import java.util.Stack;

/**
 * Java：有效的括号
 */
public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
        String s = "([";
        System.out.println(solution.isValid(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s.length()==0) {
                return true;
            }
            if (s.length() < 2) {
                return false;
            }
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(1);
                } else if (s.charAt(i) == '[') {
                    stack.push(2);
                } else if (s.charAt(i) == '{') {
                    stack.push(3);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        Integer pop = stack.pop();
                        if (s.charAt(i) == ')' && pop == 1 || s.charAt(i) == ']' && pop == 2 || s.charAt(i) == '}' && pop == 3) {
                            continue;
                        } else {
                            return false;
                        }
                    }
                }
            }
            if (!stack.isEmpty()) {
                return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
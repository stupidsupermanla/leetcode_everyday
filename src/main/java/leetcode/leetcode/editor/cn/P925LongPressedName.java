//你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。 
//
// 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。 
//
// 
//
// 示例 1： 
//
// 输入：name = "alex", typed = "aaleex"
//输出：true
//解释：'alex' 中的 'a' 和 'e' 被长按。
// 
//
// 示例 2： 
//
// 输入：name = "saeed", typed = "ssaaedd"
//输出：false
//解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
// 
//
// 示例 3： 
//
// 输入：name = "leelee", typed = "lleeelee"
//输出：true
// 
//
// 示例 4： 
//
// 输入：name = "laiden", typed = "laiden"
//输出：true
//解释：长按名字中的字符并不是必要的。
// 
//
// 
//
// 提示： 
//
// 
// name.length <= 1000 
// typed.length <= 1000 
// name 和 typed 的字符都是小写字母。 
// 
//
// 
//
// 
// Related Topics 双指针 字符串


package leetcode.leetcode.editor.cn;

/**
 * Java：长按键入
 */
public class P925LongPressedName {
    public static void main(String[] args) {
        Solution solution = new P925LongPressedName().new Solution();
        // TO TEST
        String name = "";
        String typed = "aaleexxr";
        System.out.println(solution.isLongPressedName(name, typed));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isLongPressedName(String name, String typed) {
            if (name.equals(typed)){
                return true;
            }
            int i = 0, j = 0, l = 1;
            while (i < name.length()) {
                char ii = name.charAt(i);
                while (i + 1 < name.length() && ii == name.charAt(i + 1)) {
                    i++;
                    l++;
                }
                for (int k = 0; k < l; k++) {
                    if (k+j >=typed.length() || ii != typed.charAt(k+j)) {
                        return false;
                    }
                }
                while (j + 1 < typed.length() && ii == typed.charAt(j + 1)) {
                    j++;
                }
                i++;
                j++;
                l = 1;
            }
            return j == typed.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
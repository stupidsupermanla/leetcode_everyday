//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串


package leetcode.leetcode.editor.cn;

//Java：验证回文串
public class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        // TO TEST
        String s = ",,";
        System.out.println(solution.isPalindrome(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            s = s.replace(" ", "");
            int len = s.length();
            if (len <= 1) {
                return true;
            }
            int start = 0;
            int end = len - 1;
            String[] split = s.split("");
            String reg = "^[a-zA-Z0-9]$";
            while (start <= end) {
                while (!split[start].matches(reg) && start < len - 1) {
                    start++;
                }
                while (!split[end].matches(reg) && 0 < end) {
                    end--;
                }
                if (start > end) {
                    return true;
                }
                if (split[start].toLowerCase().equals(split[end].toLowerCase())) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
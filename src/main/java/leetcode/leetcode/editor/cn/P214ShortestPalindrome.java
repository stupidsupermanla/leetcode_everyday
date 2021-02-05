//给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。 
//
// 示例 1: 
//
// 输入: "aacecaaa"
//输出: "aaacecaaa"
// 
//
// 示例 2: 
//
// 输入: "abcd"
//输出: "dcbabcd" 
// Related Topics 字符串


package leetcode.leetcode.editor.cn;

/**
 * Java：最短回文串
 */
public class P214ShortestPalindrome {
    public static void main(String[] args) {
        Solution solution = new P214ShortestPalindrome().new Solution();
        // TO TEST
        System.out.println(solution.shortestPalindrome("aacecaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String shortestPalindrome(String s) {
            String ss = new StringBuilder(s).reverse().toString();
            int kmp = kmp(ss, s);
            return new StringBuilder(s.substring(kmp)).reverse().append(s).toString();
        }

        private int kmp(String s, String p) {
            int[] next = getNext(p);
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                while (j > 0 && p.charAt(j) != s.charAt(i)) {
                    j = next[j];
                }
                if (s.charAt(i) == p.charAt(j)) {
                    j++;
                }
            }
            return j;
        }

        private int[] getNext(String p) {
            int len = p.length();
            int[] result = new int[len];
            int j = 0;
            for (int i = 2; i < len; i++) {
                while (j != 0 && p.charAt(j) != p.charAt(i - 1)) {
                    j = result[j];
                }
                if (p.charAt(j) == p.charAt(i - 1)) {
                    j++;
                }
                result[i] = j;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
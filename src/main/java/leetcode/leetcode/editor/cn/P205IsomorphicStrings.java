//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表


package leetcode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Java：同构字符串
 */
public class P205IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new P205IsomorphicStrings().new Solution();
        // TO TEST
        System.out.println(solution.isIsomorphic("paper", "title"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            int len = s.length();
            Map<Character, Character> maps = new HashMap<>();
            Map<Character, Character> mapt = new HashMap<>();
            for (int i = 0; i < len; i++) {
                char cs = s.charAt(i);
                char ct = t.charAt(i);
                if ((maps.containsKey(cs) && maps.get(cs) != ct) || (mapt.containsKey(ct) && mapt.get(ct) != cs)) {
                    return false;
                }
                maps.put(cs, ct);
                mapt.put(ct, cs);

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
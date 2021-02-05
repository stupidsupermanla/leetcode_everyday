//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意：字符串长度 和 k 不会超过 104。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 双指针 Sliding Window


package leetcode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Java：替换后的最长重复字符
 */
public class P424LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new P424LongestRepeatingCharacterReplacement().new Solution();
        // TO TEST
        System.out.println(solution.characterReplacement("", 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            Map<Character, Integer> countMap = new HashMap<>();
            int len = s.length();
            if (k>len){
                return len;
            }
            for (int i = 0; i < k; i++) {
                char c = s.charAt(i);
                Integer count = countMap.getOrDefault(c, 0);
                count++;
                countMap.put(c,count);
            }
            int left =0;
            int right =k;
            int max =0;
            while (right<len){
                char c = s.charAt(right);
                Integer count = countMap.getOrDefault(c, 0);
                count++;
                countMap.put(c,count);
                max = Math.max(count,max);
                if (right-left+1>max+k){
                    countMap.put(s.charAt(left),countMap.get(s.charAt(left))-1);
                    left++;
                }
                right++;
            }
            return right-left;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
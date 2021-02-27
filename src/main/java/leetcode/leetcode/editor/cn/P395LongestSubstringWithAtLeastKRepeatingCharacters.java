//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文字母组成 
// 1 <= k <= 105 
// 
// Related Topics 递归 分治算法 Sliding Window


package leetcode.leetcode.editor.cn;

import java.util.*;

/**
 * Java：至少有 K 个重复字符的最长子串
 */
public class P395LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P395LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        // TO TEST
        System.out.println(solution.longestSubstring("bbaaacbd", 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int k;
        String s;
        int max = 0;

        public int longestSubstring(String s, int k) {
            this.k = k;
            this.s = s;
            int len = s.length();
            dfs(0, len - 1);
            return max;
        }

        private void dfs(int left, int right) {
            if (left > right) {
                return;
            }
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = left; i <= right; i++) {
                int postion = s.charAt(i) - 'a';
                List<Integer> list = map.getOrDefault(postion, new ArrayList<>());
                list.add(i);
                map.put(postion, list);
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            Set<Integer> keys = map.keySet();
            for (Integer key : keys) {
                List<Integer> list = map.get(key);
                if (list.size() < k) {
                    for (Integer integer : list) {
                        queue.offer(integer);
                    }
                }
            }
            if (queue.isEmpty()) {
                max = Math.max(right - left + 1, max);
                return;
            }
            int start = left;
            while (!queue.isEmpty()) {
                Integer end = queue.poll();
                dfs(start, end - 1);
                start = end + 1;
            }
            dfs(start, right);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
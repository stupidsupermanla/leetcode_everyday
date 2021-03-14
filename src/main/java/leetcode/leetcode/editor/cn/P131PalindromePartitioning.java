//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 深度优先搜索 动态规划 回溯算法


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：分割回文串
 */
public class P131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new P131PalindromePartitioning().new Solution();
        // TO TEST
        List<List<String>> aab = solution.partition("aab");
        for (List<String> list : aab) {
            list.forEach(l-> System.out.print(l+","));
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String s;
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int len;

        public List<List<String>> partition(String s) {
            this.s = s;
            this.len = s.length();
            dfs(0);
            return result;
        }

        private void dfs(int i) {
            if (i == len) {
                result.add(new ArrayList<>(temp));
                return;
            }
            for (int j = i; j < len; ++j) {
                if (judge(i, j)) {
                    temp.add(s.substring(i, j + 1));
                    dfs(j + 1);
                    temp.remove(temp.size() - 1);
                }
            }
        }

        private boolean judge(int i, int j) {
            if (j - i <= 0) {
                return true;
            }
            int left = i;
            int right = j;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
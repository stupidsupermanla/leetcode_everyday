//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Java：单词搜索
 */
public class P79WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST
        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(solution.exist(board, "ABCB"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            int len = word.length();
            int[] xs = new int[]{1, -1, 0, 0};
            int[] ys = new int[]{0, 0, 1, -1};
            int yMax = board.length;
            int xMax = board[0].length;
            int i = 0;
            List<String> visits = new ArrayList<>();
            for (int j = 0; j < yMax; j++) {
                for (int k = 0; k < xMax; k++) {
                    if (board[j][k] == word.charAt(i)) {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{j, k});
                        visits.add(j + "" + k);
                        while (!queue.isEmpty() && i<len-1) {
                            i++;
                            int[] ints = queue.poll();
                            int y = ints[0];
                            int x = ints[1];
                            for (int l = 0; l < 4; l++) {
                                int ny = y + ys[l];
                                int nx = x + xs[l];
                                if (ny >= 0 && ny < yMax && nx >= 0 && nx < xMax && board[ny][nx] == word.charAt(i) && !visits.contains(ny + "" + nx)) {
                                    queue.add(new int[]{ny, nx});
                                    visits.add(ny + "" + nx);
                                }
                            }
                        }
                        if (i == len-1) {
                            return true;
                        } else {
                            i = 0;
                            visits.clear();
                        }
                    }
                }
            }
            return i == len-1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
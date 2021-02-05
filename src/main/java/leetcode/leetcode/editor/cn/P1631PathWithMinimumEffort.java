//你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
// col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你
//每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。 
//
// 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。 
//
// 请你返回从左上角走到右下角的最小 体力消耗值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
//输出：2
//解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
//这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
//输出：1
//解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
// 
//
// 示例 3： 
//
// 
//输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//输出：0
//解释：上图所示路径不需要消耗任何体力。
// 
//
// 
//
// 提示： 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 106 
// 
// Related Topics 深度优先搜索 并查集 图 二分查找


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Java：最小体力消耗路径
 */
public class P1631PathWithMinimumEffort {
    public static void main(String[] args) {
        Solution solution = new P1631PathWithMinimumEffort().new Solution();
        // TO TEST {{1,2,2},{3,8,2},{5,3,5}}[1,2,3],[3,8,4],[5,3,5
        //[[4,3,4,10,5,5,9,2],[10,8,2,10,9,7,5,6],[5,8,10,10,10,7,4,2],[5,1,3,1,1,3,1,9],[6,4,10,6,10,9,4,6]]
        System.out.println(solution.minimumEffortPath(new int[][]{{4,3,4,10,5,5,9,2}, {10,8,2,10,9,7,5,6}, {5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> list = new ArrayList<>();

        public int minimumEffortPath(int[][] heights) {
            int yLen = heights.length;
            int xLen = heights[0].length;
            int len = yLen * xLen;
            for (int i = 0; i < len; i++) {
                list.add(i);
            }
            List<int[]> costList = new ArrayList<>();
            for (int i = 0; i < yLen; i++) {
                for (int j = 0; j < xLen; j++) {
                    int cost = heights[i][j];
                    int idx = i * xLen + j;
                    if (i > 0) {
                        costList.add(new int[]{idx - xLen, idx, Math.abs(cost - heights[i - 1][j])});
                    }
                    if (j > 0) {
                        costList.add(new int[]{idx, idx - 1, Math.abs(cost - heights[i][j - 1])});
                    }
                }
            }
            costList.sort(Comparator.comparingInt(a -> a[2]));
            for (int[] cost : costList) {
                connect(cost[0], cost[1]);
                if (find(0) == find(len - 1)) {
                    return cost[2];
                }
            }
            return 0;
        }

        private void connect(int idx1, int idx2) {
            int r1 = find(idx1), r2 = find(idx2);
            if (r1 != r2) {
                list.set(r1, r2);
            }
        }

        private int find(int x) {
            if (list.get(x) != x) {
                list.set(x, find(list.get(x)));
            }
            return list.get(x);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
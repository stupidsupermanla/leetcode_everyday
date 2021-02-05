//给定一个整数矩阵，找出最长递增路径的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。 
//
// 示例 1: 
//
// 输入: nums = 
//[
//  [9,9,4],
//  [6,6,8],
//  [2,1,1]
//] 
//输出: 4 
//解释: 最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2: 
//
// 输入: nums = 
//[
//  [3,4,5],
//  [3,2,6],
//  [2,2,1]
//] 
//输出: 4 
//解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
// Related Topics 深度优先搜索 拓扑排序 记忆化


package leetcode.leetcode.editor.cn;

/**
 * Java：矩阵中的最长递增路径
 */
public class P329LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new P329LongestIncreasingPathInAMatrix().new Solution();
        // TO TEST
        int[][] nums = new int[][]{{1,3,2,1}};
        System.out.println("结果：");
        System.out.println(solution.longestIncreasingPath(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] plus = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int x, y;

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix.length < 1 || matrix[0].length < 1) {
                return 0;
            }
            int result = 0;
            y = matrix.length;
            x = matrix[0].length;
            int[][] newMatrix = new int[y][x];
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    result = Math.max(result, longest(matrix, i, j, newMatrix));
                }
            }
            return result;
        }

        private int longest(int[][] matrix, int i, int j, int[][] newMatrix) {
            if (newMatrix[i][j] != 0) {
                return newMatrix[i][j];
            }
            int result = 1;
            for (int[] ints : plus) {
                int newy = i + ints[0];
                int newx = j + ints[1];
                if (newy >= 0 && newy < y && newx >= 0 && newx < x && matrix[newy][newx] > matrix[i][j]) {
                    result = Math.max(result, longest(matrix, newy, newx, newMatrix) + 1);
                }
            }
            newMatrix[i][j] = result;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
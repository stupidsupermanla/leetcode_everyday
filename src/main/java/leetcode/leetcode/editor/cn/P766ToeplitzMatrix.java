//给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。 
//
// 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
//输出：true
//解释：
//在上述矩阵中, 其对角线为: 
//"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。 
//各条对角线上的所有元素均相同, 因此答案是 True 。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2],[2,2]]
//输出：false
//解释：
//对角线 "[1, 2]" 上的元素不同。 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 20 
// 0 <= matrix[i][j] <= 99 
// 
//
// 
//
// 进阶： 
//
// 
// 如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？ 
// 如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？ 
// 
// Related Topics 数组 
// 👍 200 👎 0


package leetcode.leetcode.editor.cn;

//Java：托普利茨矩阵
public class P766ToeplitzMatrix {
    public static void main(String[] args) {
        Solution solution = new P766ToeplitzMatrix().new Solution();
        // TO TEST
        System.out.println(solution.isToeplitzMatrix(new int[][]{{1, 2, 3, 4}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            int ys = matrix.length;
            int xs = matrix[0].length;
            for (int i = 0; i < ys; i++) {
                int y = i, x = 0;
                int temp = matrix[y][x];
                int plus = 1;
                while (y + plus < ys && x + plus < xs) {
                    if (temp == matrix[y + plus][x + plus]) {
                        plus++;
                    } else {
                        return false;
                    }
                }
            }
            for (int i = 0; i < xs; i++) {
                int y = 0, x = i;
                int temp = matrix[y][x];
                int plus = 1;
                while (y + plus < ys && x + plus < xs) {
                    if (temp == matrix[y + plus][x + plus]) {
                        plus++;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
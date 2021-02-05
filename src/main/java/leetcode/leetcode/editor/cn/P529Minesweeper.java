//让我们一起来玩扫雷游戏！ 
//
// 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）
//地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。 
//
// 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板： 
//
// 
// 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。 
// 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。 
// 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。 
// 如果在此次点击中，若无更多方块可被揭露，则返回面板。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 
//
//[['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'M', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E']]
//
//Click : [3,0]
//
//输出: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
// 
//
// 示例 2： 
//
// 输入: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Click : [1,2]
//
//输出: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'X', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
// 
//[['E','E','E','E','E','E','E','E'],
// ['E','E','E','E','E','E','E','M'],
// ['E','E','M','E','E','E','E','E'],
// ['M','E','E','E','E','E','E','E'],
// ['E','E','E','E','E','E','E','E'],
// ['E','E','E','E','E','E','E','E'],
// ['E','E','E','E','E','E','E','E'],
// ['E','E','M','M','E','E','E','E']]
//[0,0]
//
// ["B","B","B","B","B","B","1","E"],
// ["B","1","1","1","B","B","1","M"],
// ["1","2","M","1","B","B","1","1"],
// ["M","2","1","1","B","B","B","B"],
// ["1","1","B","B","B","B","B","B"],
// ["B","B","B","B","B","B","B","B"],
// ["B","1","2","2","1","B","B","B"],
// ["B","1","M","M","1","B","B","B"]]
//
// ["B","B","B","B","B","B","1","E"],
// ["B","1","1","1","B","B","1","M"],
// ["1","E","M","1","B","B","1","1"],
// ["M","E","1","1","B","B","B","B"],
// ["1","1","B","B","B","B","B","B"],
// ["B","B","B","B","B","B","B","B"],
// ["B","1","2","2","1","B","B","B"],
// ["B","1","M","M","1","B","B","B"]]
// 注意： 
//
// 
// 输入矩阵的宽和高的范围为 [1,50]。 
// 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。 
// 输入面板不会是游戏结束的状态（即有地雷已被挖出）。 
// 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。 
// 
// Related Topics 深度优先搜索 广度优先搜索


package leetcode.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Java：扫雷游戏
 */
public class P529Minesweeper {
    public static void main(String[] args) {
        Solution solution = new P529Minesweeper().new Solution();
        // TO TEST
        char[][] board = new char[][]{
                {'E','E','E','E','E','E','E','E'},
                {'E','E','E','E','E','E','E','M'},
                {'E','E','M','E','E','E','E','E'},
                {'M','E','E','E','E','E','E','E'},
                {'E','E','E','E','E','E','E','E'},
                {'E','E','E','E','E','E','E','E'},
                {'E','E','E','E','E','E','E','E'},
                {'E','E','M','M','E','E','E','E'}};
        solution.updateBoard(board, new int[]{0, 0});
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] ys = new int[]{1, -1, 1, -1, 0, 0, 1, -1};
        int[] xs = new int[]{1, -1, 0, 0, 1, -1, -1, 1};
        public char[][] updateBoard(char[][] board, int[] click) {
            int y = click[0];
            int x = click[1];
            if (board[y][x] == 'M') {
                board[y][x] = 'X';
                return board;
            }
            int yMax = board.length;
            int xMax = board[0].length;
            Pair<Integer, Integer> pair = new Pair<>(y, x);
            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
            queue.add(pair);
            while (!queue.isEmpty()) {
                Pair<Integer, Integer> p = queue.poll();
                Integer yy = p.getKey();
                Integer xx = p.getValue();
                if (board[yy][xx] != 'E') {
                    continue;
                }
                int num = getMs(yy, xx, board, yMax, xMax);
                if (num > 0) {
                    board[yy][xx] = Character.forDigit(num, 10);
                } else {
                    board[yy][xx] = 'B';
                    for (int i = 0; i < 8; i++) {
                        int ny = yy + ys[i];
                        int nx = xx + xs[i];
                        if (ny >= 0 && nx >= 0 && ny < yMax && nx < xMax && board[ny][nx] == 'E') {
                            queue.add(new Pair<>(ny, nx));
                        }
                    }
                }
            }
            return board;
        }

        private int getMs(int y, int x, char[][] board, int yMax, int xMax) {
            int result = 0;
            for (int i = 0; i < 8; i++) {
                int ny = y + ys[i];
                int nx = x + xs[i];
                if (ny >= 0 && nx >= 0 && ny < yMax && nx < xMax && board[ny][nx] == 'M') {
                    result++;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
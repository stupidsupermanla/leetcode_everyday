//用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [
//a, b] 连接了计算机 a 和 b。 
//
// 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。 
//
// 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连
//通所需的最少操作次数。如果不可能，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
//输出：1
//解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
// 
//
// 示例 2： 
//
// 
//
// 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
//输出：2
// 
//
// 示例 3： 
//
// 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
//输出：-1
//解释：线缆数量不足。
// 
//
// 示例 4： 
//
// 输入：n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^5 
// 1 <= connections.length <= min(n*(n-1)/2, 10^5) 
// connections[i].length == 2 
// 0 <= connections[i][0], connections[i][1] < n 
// connections[i][0] != connections[i][1] 
// 没有重复的连接。 
// 两台计算机不会通过多条线缆连接。 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Java：连通网络的操作次数
 */
public class P1319NumberOfOperationsToMakeNetworkConnected {
    public static void main(String[] args) {
        Solution solution = new P1319NumberOfOperationsToMakeNetworkConnected().new Solution();
        // TO TEST {0,1},{0,2},{0,3},{1,2},{1,3}
        // {0,1},{0,2},{3,4},{2,3}
        // {0,1},{0,2},{0,3},{1,2}
        // {{17,51},{33,83},{53,62},{25,34},{35,90},{29,41},{14,53},{40,84},{41,64},{13,68},{44,85},{57,58},{50,74},{20,69},{15,62},{25,88},{4,56},{37,39},{30,62},{69,79},{33,85},{24,83},{35,77},{2,73},{6,28},{46,98},{11,82},{29,72},{67,71},{12,49},{42,56},{56,65},{40,70},{24,64},{29,51},{20,27},{45,88},{58,92},{60,99},{33,46},{19,69},{33,89},{54,82},{16,50},{35,73},{19,45},{19,72},{1,79},{27,80},{22,41},{52,61},{50,85},{27,45},{4,84},{11,96},{0,99},{29,94},{9,19},{66,99},{20,39},{16,85},{12,27},{16,67},{61,80},{67,83},{16,17},{24,27},{16,25},{41,79},{51,95},{46,47},{27,51},{31,44},{0,69},{61,63},{33,95},{17,88},{70,87},{40,42},{21,42},{67,77},{33,65},{3,25},{39,83},{34,40},{15,79},{30,90},{58,95},{45,56},{37,48},{24,91},{31,93},{83,90},{17,86},{61,65},{15,48},{34,56},{12,26},{39,98},{1,48},{21,76},{72,96},{30,69},{46,80},{6,29},{29,81},{22,77},{85,90},{79,83},{6,26},{33,57},{3,65},{63,84},{77,94},{26,90},{64,77},{0,3},{27,97},{66,89},{18,77},{27,43}}
        System.out.println(solution.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        public int makeConnected(int n, int[][] connections) {
            int canR = 0;
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            for (int[] connection : connections) {
                int i1 = connection[0];
                int i2 = connection[1];
                int r1 = find(i1);
                int r2 = find(i2);
                if (r1 == r2) {
                    canR++;
                } else {
                    list.set(r1, r2);
                }
            }
            for (int i = 0; i < n; i++) {
                set.add(find(i));
            }
            int needC = set.size() - 1;

            return canR >= needC ? needC : -1;
        }

        private int find(int num) {
            if (list.get(num) != num) {
                list.set(num, find(list.get(num)));
            }
            return list.get(num);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
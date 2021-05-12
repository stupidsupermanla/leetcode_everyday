//有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。 
//
// 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为
//本次查询的结果。 
//
// 并返回一个包含给定查询 queries 所有结果的数组。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
//输出：[2,7,14,8] 
//解释：
//数组中元素的二进制表示形式是：
//1 = 0001 
//3 = 0011 
//4 = 0100 
//8 = 1000 
//查询的 XOR 值为：
//[0,1] = 1 xor 3 = 2 
//[1,2] = 3 xor 4 = 7 
//[0,3] = 1 xor 3 xor 4 xor 8 = 14 
//[3,3] = 8
// 
//
// 示例 2： 
//
// 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
//输出：[8,0,4,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 10^4 
// 1 <= arr[i] <= 10^9 
// 1 <= queries.length <= 3 * 10^4 
// queries[i].length == 2 
// 0 <= queries[i][0] <= queries[i][1] < arr.length 
// 
// Related Topics 位运算 
// 👍 94 👎 0


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：子数组异或查询
public class P1310XorQueriesOfASubarray {
    public static void main(String[] args) {
        Solution solution = new P1310XorQueriesOfASubarray().new Solution();
        // TO TEST
        int[] ints = solution.xorQueries(new int[]{1,3,4,8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}});
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int len = arr.length;
            List<Integer> list = new ArrayList<>(len);
            Integer pre = null;
            for (int i : arr) {
                if (pre == null) {
                    pre = i;
                } else {
                    pre ^= i;
                }
                list.add(pre);
            }
            int qLen = queries.length;
            int[] result = new int[qLen];
            for (int i = 0; i < qLen; i++) {
                int[] query = queries[i];
                if (query[0]==0) {
                    result[i] = list.get(query[1]);
                }else {
                    result[i] =  list.get(query[0]-1) ^ list.get(query[1]);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
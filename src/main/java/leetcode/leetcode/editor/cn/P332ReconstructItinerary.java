//给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 
//JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。 
//
// 说明: 
//
// 
// 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排
//序更靠前 
// 所有的机场都用三个大写字母表示（机场代码）。 
// 假定所有机票至少存在一种合理的行程。 
// 
//
// 示例 1: 
//
// 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
// 
//
// 示例 2: 
//
// 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。 
// Related Topics 深度优先搜索 图


package leetcode.leetcode.editor.cn;

import java.util.*;

/**
 * Java：重新安排行程
 */
public class P332ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new P332ReconstructItinerary().new Solution();
        // TO TEST
        List<List<String>> tickets = new ArrayList<>();
//        tickets.add(Arrays.asList("JFK","SFO"));
//        tickets.add(Arrays.asList("JFK","ATL"));
//        tickets.add(Arrays.asList("SFO","ATL"));
//        tickets.add(Arrays.asList("ATL","JFK"));
//        tickets.add(Arrays.asList("ATL","SFO"));
        tickets.add(Arrays.asList("JFK", "NRT"));
        tickets.add(Arrays.asList("JFK", "KUL"));

        tickets.add(Arrays.asList("NRT", "JFK"));


        List<String> itinerary = solution.findItinerary(tickets);
        for (String s : itinerary) {
            System.out.println(s);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                String from = ticket.get(0);
                if (map.containsKey(from)) {
                    List<String> tos = map.get(from);
                    addToList(ticket.get(1), tos);
                    map.put(from, tos);
                } else {
                    List<String> tos = new ArrayList<>();
                    tos.add(ticket.get(1));
                    map.put(from, tos);
                }
            }
            addToResult("JFK");
            Collections.reverse(result);
            return result;
        }

        private void addToResult(String from) {
            while (map.containsKey(from) && map.get(from).size() > 0) {
                List<String> tos = map.get(from);
                String tmp = tos.get(0);
                tos.remove(0);
                addToResult(tmp);
            }
            result.add(from);
        }

        private void addToList(String to, List<String> tos) {
            for (int i = 0; i < tos.size(); i++) {
                if (to.compareTo(tos.get(i)) < 0) {
                    tos.add(i, to);
                    return;
                }
            }
            tos.add(to);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
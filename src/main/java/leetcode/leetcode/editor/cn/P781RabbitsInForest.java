//森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。 
//
// 返回森林中兔子的最少数量。 
//
// 
//示例:
//输入: answers = [1, 1, 2]
//输出: 5
//解释:
//两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
//之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
//设回答了 "2" 的兔子为蓝色。
//此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
//因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
//
//输入: answers = [10, 10, 10]
//输出: 11
//
//输入: answers = []
//输出: 0
// 
//
// 说明: 
//
// 
// answers 的长度最大为1000。 
// answers[i] 是在 [0, 999] 范围内的整数。 
// 
// Related Topics 哈希表 数学 
// 👍 110 👎 0


package leetcode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Java：森林中的兔子
 */
public class P781RabbitsInForest {
    public static void main(String[] args) {
        Solution solution = new P781RabbitsInForest().new Solution();
        // TO TEST
        System.out.println(solution.numRabbits(new int[]{1,2,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> map = new HashMap<>();
            int result = 0;
            for (int answer : answers) {
                if (answer == 0) {
                    result++;
                    continue;
                }
                Integer count = map.getOrDefault(answer, 0);
                if (count % (answer + 1) == 0) {
                    result += answer + 1;
                }
                count++;
                map.put(answer,count);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
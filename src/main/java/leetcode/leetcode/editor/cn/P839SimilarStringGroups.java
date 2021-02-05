//如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
//
//
// 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "t
//ars"，"rats"，或 "arts" 相似。
//
// 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同
//一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
//
// 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
//
//
//
// 示例 1：
//
//
//输入：strs = ["tars","rats","arts","star"]
//输出：2
//
//
// 示例 2：
//
//
//输入：strs = ["omv","ovm"]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 100
// 1 <= strs[i].length <= 1000
// sum(strs[i].length) <= 2 * 104
// strs[i] 只包含小写字母。
// strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。
//
//
//
//
// 备注：
//
// 字母异位词（anagram），一种把某个字符串的字母的位置（顺序）加以改换所形成的新词。
// Related Topics 深度优先搜索 并查集 图


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Java：相似字符串组
 */
public class P839SimilarStringGroups {
    public static void main(String[] args) {
        Solution solution = new P839SimilarStringGroups().new Solution();
        // TO TEST
        //["kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"]
        System.out.println(solution.numSimilarGroups(new String[]{"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> list = new ArrayList<>();

        private int find(int x){
            if (x!=list.get(x)){
                list.set(x,find(list.get(x)));
            }
            return list.get(x);
        }

        public int numSimilarGroups(String[] strs) {
            int len = strs.length;
            for (int i = 0; i < len; i++) {
                list.add(i);
            }
            for (int i = 0; i < len; i++) {
                String si = strs[i];
                for (int j = i + 1; j < len; j++) {
                    String sj = strs[j];
                    if (check(si, sj)) {
                        int r1 = find(i);
                        int r2 = find(j);
                        if (r1!=r2){
                            list.set(r1,r2);
                        }
                    }
                }
            }
            Set<Integer> set=new HashSet<>();
            for (int i = 0; i < list.size(); i++) {
                set.add(find(i));
            }
            return set.size();



//            Map<String, List<String>> map = new HashMap<>();
//            Set<String> visitedSet = new HashSet<>();
//            for (int i = 0; i < strs.length; i++) {
//                String s = strs[i];
//                if (visitedSet.contains(s)) {
//                    continue;
//                }
//                visitedSet.add(s);
//                map.put(s,new ArrayList<>());
//                for (int j = i + 1; j < strs.length; j++) {
//                    String str = strs[j];
//                    if (visitedSet.contains(str)) {
//                        continue;
//                    }
//                    List<String> list = map.get(s);
//                    for (String st : list) {
//                        if (check(str, st)) {
//                            List<String> l = map.get(s);
//                            l.add(str);
//                            visitedSet.add(str);
//                            break;
//                        }
//                    }
//                    if (check(s, str)) {
//                        list.add(str);
//                        visitedSet.add(str);
//                    }
//                }
//            }
//            return map.size();
        }

        private boolean check(String s1, String s2) {
            int num = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    num++;
                }
                if (num > 2) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
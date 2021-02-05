//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。 
//
// 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：复原IP地址
 */
public class P93RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new P93RestoreIpAddresses().new Solution();
        // TO TEST
        List<String> strings = solution.restoreIpAddresses("0000");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> resultList = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            getIp(s, 4, "");
            return resultList;
        }

        private void getIp(String s, int n, String result) {
            int len = 3;
            if (s.length() == 0) {
                return;
            } else if (s.length() < 3) {
                len = s.length();
            }
            if (n > 1) {
                String s1 = s.substring(0, 1);
                if ("0".equals(s1)) {
                    result = result + s1 + ".";
                    getIp(s.substring(1), n - 1, result);
                } else {
                    for (int j = 1; j <= len; j++) {
                        s1 = s.substring(0, j);
                        if (Integer.valueOf(s1) > 255) {
                            return;
                        }
//                        s = s.substring(j + 1);
                        int length = result.length();
                        result = result + s1 + ".";
                        getIp(s.substring(j), n - 1, result);
                        result = result.substring(0, length);
                    }
                }
            } else {
                if (s.equals("0")) {
                    result = result + s;
                    resultList.add(result);
                    return;
                }
                if (s.indexOf("0") == 0) {
                    return;
                }
                if (s.length()>3){
                    return;
                }
                if (Integer.parseInt(s) > 255) {
                    return;
                }
                result = result + s;
                resultList.add(result);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
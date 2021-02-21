package mainTime;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20210221 {

    public static void main(String[] args) {
        //System.out.println(mergeAlternately("a", ""));
//        int[] ints = minOperations("");
//        for (int anInt : ints) {
//            System.out.print(anInt+",");
//        }
        System.out.println(maximumScore(new int[]{-5,-3,-3,-2,7,1}, new int[]{-10,-5,3,4,6}));
//        System.out.println(longestPalindrome("ab", "ab"));
//        System.out.println(find("ceebeddcd"));
        //"ceebeddc"
        //"d"
    }

    public static int longestPalindrome(String word1, String word2) {
        return longestPalindromeSubseq(word1 + word2, word1.length());
    }

    public static int longestPalindromeSubseq(String s, int l) {
        int len = s.length();
        int max = 0;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    //保证 取到 word1与word2中的字母
                    if (i < l && j >= l) {
                        max = Math.max(max, dp[i][j]);
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return max;
    }

    static int[] m;

    public static int maximumScore(int[] nums, int[] multipliers) {
//        m = multipliers;
//        int len = nums.length;
//        int result = dfs(nums, 0, len - 1, 0);
//        return result;
        int mLen = multipliers.length;
        int nLen = nums.length;
        int[] dp = new int[mLen + 1];
        int max = Integer.MIN_VALUE;
        //i为第几次 j为左边取几个，右边取几个的最大值
        for (int i = 1; i <= mLen; i++) {
            for (int j = i; j >= 0; j--) {
                int r = nLen - i + j - 1;
                dp[j] = Math.max(j > 0 ? dp[j - 1] + nums[j - 1] * multipliers[i - 1] : Integer.MIN_VALUE,
                        r < nLen - 1 ? dp[j] + nums[r + 1] * multipliers[i - 1] : Integer.MIN_VALUE);
                if (i == mLen) {
                    max = Math.max(max, dp[j]);
                }
            }
        }
        return max;
    }

    private static int dfs(int[] nums, int left, int right, int index) {
        if (m.length == index) {
            return 0;
        }
        int reL = m[index] * nums[left] + dfs(nums, left + 1, right, index + 1);
        int reR = m[index] * nums[right] + dfs(nums, left, right - 1, index + 1);
        return Math.max(reL, reR);
    }

    public static int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] result = new int[len];
        Set<Integer> p = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (boxes.charAt(i) == '1') {
                p.add(i);
            }
        }
        for (int i = 0; i < len; i++) {
            int temp = 0;
            for (Integer integer : p) {
                temp += Math.abs(i - integer);
            }
            result[i] = temp;
        }
        return result;
    }

    public static String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder result = new StringBuilder();
        int index1 = 0;
        int index2 = 0;
        boolean flag = true;
        while (index1 < len1 || index2 < len2) {
            if (index1 >= len1) {
                result.append(word2.charAt(index2));
                index2++;
            } else if (index2 >= len2) {
                result.append(word1.charAt(index1));
                index1++;
            } else {
                if (flag) {
                    result.append(word1.charAt(index1));
                    index1++;
                } else {
                    result.append(word2.charAt(index2));
                    index2++;
                }
                flag = !flag;
            }
        }
        return result.toString();
    }
}

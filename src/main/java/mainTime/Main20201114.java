package mainTime;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20201114 {
    public static void main(String[] args) {
//        int[] decrypt = decrypt(new int[]{2}, 1);
//        for (int i : decrypt) {
//            System.out.println(i);
//        }
//        System.out.println(minimumDeletions("aaabaaabbbaa"));
        int i = minimumJumps(new int[]{162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98}, 29, 98, 80);
        System.out.println(i);
    }

    public static int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int temp = 0;
            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    int p = i + j;
                    if (p >= len) {
                        p = p - len;
                    }
                    temp += code[p];
                }
            }
            if (k < 0) {
                for (int j = -1; j >= k; j--) {
                    int p = i + j;
                    if (p < 0) {
                        p = p + len;
                    }
                    temp += code[p];
                }
            }
            result[i] = temp;
        }
        return result;
    }

    public static int minimumDeletions(String s) {
        int len = s.length();
        int[][] f = new int[len][2];
        f[0][0] = s.charAt(0) == 'b' ? 1 : 0;
        f[0][1] = 0;
        for (int i = 1; i < len; i++) {
            int isb = s.charAt(i) == 'b' ? 1 : 0;
            f[i][0] = f[i - 1][0] + isb;
            f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + Math.abs(isb - 1);
        }
        return Math.min(f[len - 1][0], f[len - 1][1]);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static Set<Integer> set = new HashSet<>();
    static int t;
    static private int[] dp = new int[4001];

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        t = x;
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i : forbidden) {
            set.add(i);
        }
        int s1 = a;
        int s2 = a - b;
        if (a > b) {
            if (!set.contains(s1)) {
                int just = just(s1, s1, s2, 1);
                if (just > 0) {
                    return just;
                }
            }
            if (!set.contains(s2)) {
                int just = just(s2, s1, s2, 2);
                if (just > 0) {
                    return just;
                }
            }
        }
        if (a < b) {
            if (!set.contains(s1)) {
                int just = just(s1, s1, s2, 1);
                if (just > 0) {
                    return just;
                }
            }
        }
        return -1;
    }

    private static int just(int t1, int s1, int s2, int index) {
        if (t1 == t) {
            return index;
        }
        dp[t1] = index;
        if (!set.contains(t1 + s1) && (t1 + s1) >= 0 && (t1 + s1) <= 4000 && index < dp[t1 + s1]) {
            int just = just(t1 + s1, s1, s2, index + 1);
            if (just > 0) {
                return just;
            }
        }
        if (!set.contains(t1 + s2) && (t1 + s2) >= 0 && (t1 + s2) <= 4000 && index < dp[t1 + s2]) {
            int just = just(t1 + s2, s1, s2, index + 2);
            if (just > 0) {
                return just;
            }
        }
        return 0;
    }

}

package mainTime;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20201213 {

    public static void main(String[] args) {
//        System.out.println(numberOfMatches(2));
//        System.out.println(minPartitions(""));
        System.out.println(stoneGameVII(new int[]{5,3,1,4,2}));
    }

    public static int numberOfMatches(int n) {
        int result = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
                result += n;
            } else {
                n = (n - 1) / 2 + 1;
                result += n - 1;
            }
        }
        return result;
    }

    public static int minPartitions(String n) {
        int max = 0;
        String[] ss = n.split("");
        for (String s : ss) {
            max = Math.max(Integer.valueOf(s), max);
        }
        return max;
    }

    static int len;

    public static int stoneGameVII(int[] stones) {
        len = stones.length;
        int[][] dp1 = new int[len + 1][2];
        int[][] dp2 = new int[len + 1][2];
        get(1, dp1, dp2, 0, 0, stones, 0, len - 1);
        if (len%2==1) {
            return Math.abs(Math.max(dp1[len][0], dp1[len][1]) - Math.max(dp2[len - 1][0], dp2[len - 1][1]));
        }
        return Math.abs(Math.max(dp1[len-1][0], dp1[len-1][1]) - Math.max(dp2[len ][0], dp2[len ][1]));
    }

    private static void get(int i, int[][] dp1, int[][] dp2, int sum1, int sum2, int[] stones, int start, int end) {
        if (i > len) {
            return;
        }
        if (i % 2 == 1) {
            int s1 = 0;
            for (int k = start + 1; k <= end; k++) {
                s1 += stones[k];
            }
            s1 += sum1;
            dp1[i][0] = Math.max(dp1[i][0], s1);
            get(i + 1, dp1, dp2, s1, sum2, stones, start + 1, end);
            int s2 = 0;
            for (int k = start; k <= end - 1; k++) {
                s2 += stones[k];
            }
            s2 += sum1;
            dp1[i][1] = Math.max(dp1[i][1], s2);
            get(i + 1, dp1, dp2, s2, sum2, stones, start, end - 1);
        } else {
            int s1 = 0;
            for (int k = start + 1; k <= end; k++) {
                s1 += stones[k];
            }
            s1 += sum2;
            dp2[i][0] = Math.max(dp2[i][0], s1);
            get(i + 1, dp1, dp2, sum1, s1, stones, start + 1, end);
            int s2 = 0;
            for (int k = start; k <= end - 1; k++) {
                s2 += stones[k];
            }
            s2 += sum2;
            dp2[i][1] = Math.max(dp2[i][1], s2);
            get(i + 1, dp1, dp2, sum1, s2, stones, start, end - 1);
        }
    }
}

package mainTime;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20201122 {

    public static void main(String[] args) {
//        System.out.println(getSmallestString(77559, 896305));
//        System.out.println(waysToMakeFair(new int[]{2, 2}));
        System.out.println(minimumEffort(new int[][]{{1,3},{2,4},{10,11},{10,12},{8,9}}));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = "";
        String s2 = "";
        for (String s : word1) {
            s1 += s;
        }
        for (String s : word2) {
            s2 += s;
        }
        return s1.equals(s2);
    }

    public static String getSmallestString(int n, int k) {
        if (n == 1) {
            return String.valueOf((char) ('a' + k - 1));
        }
        StringBuilder result = new StringBuilder();
        int nz = k / 26;
        int remain = k % 26;
        if (remain < 1) {
            nz--;
            remain = 26;
        }
        n = n - nz;
        for (int i = 0; i < (n - 1); i++) {
            result.append("a");
            remain--;
            if (remain < 1) {
                nz--;
                n++;
                remain = 26;
            }
        }
        result.append((char) ('a' + remain - 1));
        for (int i = 0; i < nz; i++) {
            result.append("z");
        }
        return result.toString();
    }

    public static int waysToMakeFair(int[] nums) {
        if (nums.length <= 1) {
            return 1;
        }
        int sum = 0;
        int result = 0;
        Map<Integer, Integer> sum0Map = new HashMap<>();
        Map<Integer, Integer> sum1Map = new HashMap<>();
        int sum0 = 0;
        int sum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i % 2 == 0) {
                sum0Map.put(i, sum0);
                sum0 += nums[i];
            } else {
                sum1Map.put(i, sum1);
                sum1 += nums[i];

            }
        }
        for (int i = 0; i < nums.length; i++) {
            int newSum = sum - nums[i];
            if (newSum % 2 != 0) {
                continue;
            }
            int halfSum;
            if (i % 2 == 0) {
                halfSum = sum0Map.get(i) + sum1 - sum1Map.getOrDefault(i + 1, sum1);
            } else {
                halfSum = sum1Map.get(i) + sum0 - sum0Map.getOrDefault(i + 1, sum0);
            }
            if (newSum / 2 == halfSum) {
                result++;
            }
        }
        return result;
    }


    public static int minimumEffort(int[][] tasks) {
        Pair<Integer,Integer>[] ts = new Pair[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            int[] task=tasks[i];
            ts[i]=new Pair(task[0],task[1]);
        }
        Arrays.sort(ts, Comparator.comparingInt(x -> (x.getValue() - x.getKey())));
        int result = 0;
        int remian = 0;
        for (int i=0;i<tasks.length;i++) {
            Pair<Integer, Integer> entry = ts[i];


            result += entry.getKey();
            if (result < entry.getValue()) {
                result = entry.getValue();
            }

//
//            if (remian>=entry.getValue()){
//                remian-=entry.getValue()-entry.getKey();
//                continue;
//            }
//            result += entry.getValue() - remian;
//            remian = entry.getValue()-entry.getKey();
        }
        return result;
    }
}

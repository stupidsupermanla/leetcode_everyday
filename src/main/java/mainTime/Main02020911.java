package mainTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main02020911 {

    public static void main(String[] args) {
//        String s="a(b(c)<2>)<3>e";
//        String s = "a(b)<3>de";
//        System.out.println(t1(s));

        System.out.println(t2(new int[][]{{1, 3}, {5, 6}, {8, 9}}, 4));
    }

    public static String t1(String s) {
        while (s.contains("(")) {
            s = replaceString(s);
        }
        return s;
    }

    private static String replaceString(String s) {
        Stack<Integer> stack = new Stack<>();
        String[] ss = s.split("");
        int len = ss.length;
        String temp = "";
        String s1 = "";
        String s2 = "";
        String s3 = "";
        for (int i = 0; i < len; i++) {
            if ("(".equals(ss[i])) {
                stack.push(i);
            }
            if (")".equals(ss[i])) {
                Integer start = stack.pop();
                s1 = s.substring(0, start);
                temp = s.substring(start + 1, i);
            }
            if ("<".equals(ss[i])) {
                stack.push(i);
            }
            if (">".equals(ss[i])) {
                Integer start = stack.pop();
                s3 = s.substring(i + 1);
                int times = Integer.parseInt(s.substring(start + 1, i));
                for (int j = 0; j < times; j++) {
                    s2 += temp;
                }
                break;
            }
        }
        return s1 + s2 + s3;
    }

    static List<Integer> all = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    static int max, nS;

    public static int t2(int[][] list, int n) {
        for (int[] ints : list) {
            for (int i = ints[0]; i <= ints[1]; i++) {
                all.add(i);
            }
        }
        int len = all.size();
        if (len < n) {
            return -1;
        }
        nS = n;
        max = Integer.MIN_VALUE;
        getN(0);
        return max;
    }

    private static void getN(int index) {
        if (temp.size() >= nS) {
            int min = getMin(temp);
            if (min > max) {
                max = min;
            }
            return;
        }
        while (index < all.size()) {
            Integer integer = all.get(index);
            temp.add(integer);
            getN(index + 1);
            temp.remove(temp.size() - 1);
        }
    }

    private static int getMin(List<Integer> temp) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < temp.size(); i++) {
            int tem = temp.get(i);
            for (int j = i + 1; j < temp.size(); j++) {
                int abs = Math.abs(tem - temp.get(j));
                if (abs < min) {
                    min = abs;
                }
            }
        }
        return min;
    }
}

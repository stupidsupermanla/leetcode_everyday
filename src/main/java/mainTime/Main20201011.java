package mainTime;

import java.util.*;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20201011 {

    public static void main(String[] args) {
//        System.out.println(maxDepth(""));

        int[][] roads = new int[][]{{2, 3}, {0, 3}, {0, 4}, {4, 1}};
        System.out.println(maximalNetworkRank(5, roads));
    }

    public static int maxDepth(String s) {
        String[] split = s.split("");
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int temp = 0;
        for (String s1 : split) {
            if ("(".equals(s1)) {
                stack.push(1);
                temp++;
                if (temp > max) {
                    max = temp;
                }
            }
            if (")".equals(s1)) {
                stack.pop();
                temp--;
            }
        }
        return max;
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];
            map.get(x).add(y);
            map.get(y).add(x);
        }
        List<Integer> maxlist = new ArrayList<>();
        List<Integer> max2list = new ArrayList<>();
        int maxlen = 0;
        int max2len = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.get(i);
            if (list.size() > maxlen) {
                max2list = new ArrayList<>(maxlist);
                max2len = maxlen;
                maxlen = list.size();
                maxlist.clear();
                maxlist.add(i);
            } else if (list.size() == maxlen) {
                maxlist.add(i);
            } else if (list.size() == max2len) {
                max2list.add(i);
            } else if (list.size() > max2len) {
                max2len = list.size();
                max2list.clear();
                max2list.add(i);
            }
        }
        int result = 0;
        boolean has = true;
        if (maxlist.size() >= 2) {
            result = maxlen * 2;
            for (int i = 0; i < maxlist.size(); i++) {
                int first = maxlist.get(i);
                for (int j = 0; j < maxlist.size(); j++) {
                    if (j == i) {
                        continue;
                    }
                    Integer second = maxlist.get(j);
                    if (!map.get(second).contains(first)) {
                        has = false;
                        break;
                    }
                }
                if (!has) {
                    break;
                }
            }
        } else {
            result = maxlen + max2len;
            Integer maxi = maxlist.get(0);
            for (Integer integer : max2list) {
                if (!map.get(integer).contains(maxi)) {
                    has = false;
                    break;
                }
            }
        }
        if (has && result > 0) {
            result--;
        }
        return result;
    }


    public static boolean checkPalindromeFormation(String a, String b) {
        int len = a.length();
        boolean r1=true;
        boolean r2=true;
        for (int i = 0; i < len / 2; i++) {
            if (r1 && a.charAt(i)!=b.charAt(len-1-i)){
                r1 = false;
            }
            if (r2 && b.charAt(i)!=a.charAt(len-1-i)){
                r2 = false;
            }
            if (r1 || r2){
                break;
            }
        }
        return r1||r2;
    }
}

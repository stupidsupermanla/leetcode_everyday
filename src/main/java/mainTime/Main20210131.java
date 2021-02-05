package mainTime;

import java.util.*;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20210131 {

    public static void main(String[] args) {

//        System.out.println(countBalls(15, 25));
        //[4,-2],[1,4],[-3,1]
//        int[] ints = restoreArray(new int[][]{{4,-2}});
//        for (int anInt : ints) {
//            System.out.print(anInt+",");
//        }
        //{3,1,2},{4,10,3},{3,10,100},{4,100,30},{1,3,1}
        //
//[7,11,5,3,8]
//[[2,2,6],[4,2,4],[2,13,1000000000]]

        boolean[] booleans = canEat(new int[]{7, 11, 5, 3, 8}, new int[][]{{2, 2, 6}, {4, 2, 4}, {2, 13, 1000000000}});
        for (boolean aBoolean : booleans) {
            System.out.print(aBoolean+",");
        }
//        System.out.println(checkPartitioning("gbofdldvwelqiizbievfolrujxnwjmjwsjrjeqecwssgtlteltslfzkblzihcgwjnqaiqbxohcnxulxozzkanaofgoddogfoanakzzoxluxnchoxbqiaqnjwgchizlbkzflstletltgsswceqejrjswjmjwnxjurlofveibziiqlewvdldfobgxebrcrbexv"));

    }

    public static boolean checkPartitioning(String s) {
        List<Integer> first = new ArrayList<>();
        List<Integer> last = new ArrayList<>();
        int len = s.length();
        for (int i = 1; i < len; i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            if (check(s1)) {
                first.add(i);
            }
            if (check(s2)) {
                last.add(i);
            }
        }
        int firstLen = first.size();
        int lastLen = last.size();
        for (int i = 0; i < firstLen; i++) {
            int index1 = first.get(i);
            for (int j = 0; j < lastLen; j++) {
                int index2 = last.get(j);
                if (index1 < index2) {
                    String str = s.substring(index1, index2);
                    if (check(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean check(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        int len = candiesCount.length;
        long[] canEatCount = new long[len];
        canEatCount[0] = 0L;
        for (int i = 1; i < len; i++) {
            canEatCount[i] = canEatCount[i - 1] + (long)candiesCount[i - 1];
        }
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];
            long d = (day + 1);
            long maxCanEat= d *(long)cap;
            long canEat = canEatCount[type];
            answer[i]=canEat<maxCanEat&& d <=canEat+(long)candiesCount[type];
        }
        return answer;
    }

    public static int[] restoreArray(int[][] adjacentPairs) {
        int[] result = new int[adjacentPairs.length + 1];
        Set<Integer> s = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            int p1 = adjacentPair[0];
            int p2 = adjacentPair[1];
            Set<Integer> s1 = map.getOrDefault(p1, new HashSet<>());
            if (s1.size() == 0) {
                s.add(p1);
            } else {
                s.remove(p1);
            }
            s1.add(p2);
            map.put(p1, s1);
            Set<Integer> s2 = map.getOrDefault(p2, new HashSet<>());
            if (s2.size() == 0) {
                s.add(p2);
            } else {
                s.remove(p2);
            }
            s2.add(p1);
            map.put(p2, s2);
        }
        int first = 0;
        for (Integer integer : s) {
            first = integer;
        }
        result[0] = first;
        Set<Integer> visitedSet = new HashSet<>();
        visitedSet.add(first);
        for (int i = 1; i < result.length; i++) {
            int before = result[i - 1];
            Set<Integer> set = map.get(before);
            for (Integer integer : set) {
                if (!visitedSet.contains(integer)) {
                    result[i] = integer;
                    visitedSet.add(integer);
                }
            }
        }
        return result;
    }

    public static int countBalls(int lowLimit, int highLimit) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int box = 0;
            int num = i;
            while (num > 0) {
                box += num % 10;
                num = num / 10;
            }
            Integer count = map.getOrDefault(box, 0);
            count++;
            map.put(box, count);
            max = Math.max(max, count);
        }
        return max;
    }
}

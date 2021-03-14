package mainTime;

import java.util.*;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20210314 {

    public static void main(String[] args) {
        // System.out.println(areAlmostEqual("attack", "defend"));
//        System.out.println(findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}}));

        //System.out.println(maxAverageRatio(new int[][]{{2, 4}, {3, 9}, {4, 5},{2,10}}, 4));
        System.out.println(maximumScore(new int[]{5,4}, 0));
    }

    public static int maximumScore(int[] nums, int k) {
        int len = nums.length;
        if (len==1){
            return nums[0];
        }
        int left = k;
        int right = k;
        int result = Integer.MIN_VALUE;
        int min = nums[k];
        while (left >= 0 && right <= len - 1) {
            if (left == 0 && right == len - 1) {
                break;
            }else if (left==0){
                right++;
                min = Math.min(min, nums[right]);
            }else if (right==len-1){
                left--;
                min = Math.min(min, nums[left]);
            }else if (nums[left-1]>nums[right+1]){
                left--;
                min = Math.min(min, nums[left]);
            }else {
                right++;
                min = Math.min(min, nums[right]);
            }
            result = Math.max(result,min*(right-left+1));
        }
        return result;
    }


    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        double av = 0;
        TreeMap<Double, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < classes.length; i++) {
            int[] aClass = classes[i];
            double v = (double) aClass[0] / (double) aClass[1];
            av += v;
            double addV = (double) (aClass[0] + 1) / (double) (aClass[1] + 1) - v;
            List<Integer> list = map.getOrDefault(addV, new ArrayList<>());
            list.add(i);
            map.put(addV, list);
        }
        while (extraStudents > 0) {
            Map.Entry<Double, List<Integer>> entry = map.pollLastEntry();
            av += entry.getKey();
            List<Integer> list = entry.getValue();
            Integer post = list.get(0);
            list.remove(0);
            if (list.isEmpty()) {
                map.remove(entry.getKey());
            } else {
                map.put(entry.getKey(), list);
            }
            classes[post][0]++;
            classes[post][1]++;
            double v = (double) (classes[post][0]) / (double) (classes[post][1]);
            double addV = (double) (classes[post][0] + 1) / (double) (classes[post][1] + 1) - v;
            List<Integer> mList = map.getOrDefault(addV, new ArrayList<>());
            mList.add(post);
            map.put(addV, mList);
            extraStudents--;
        }
        return av / classes.length;
    }

    public static int findCenter(int[][] edges) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int[] edge : edges) {
            for (int i : edge) {
                Integer c = countMap.getOrDefault(i, 0);
                countMap.put(i, ++c);
            }
        }
        Set<Integer> keys = countMap.keySet();
        int n = keys.size() - 1;
        for (Integer key : keys) {
            Integer integer = countMap.get(key);
            if (integer == n) {
                return key;
            }
        }
        return 0;
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        int len = s1.length();
        int count = 0;
        char[] c1 = new char[2];
        char[] c2 = new char[2];
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (count == 2) {
                    return false;
                }
                c1[count] = s1.charAt(i);
                c2[count] = s2.charAt(i);
                count++;
            }
        }
        if (count == 1) {
            return false;
        }
        if (count == 2) {
            Arrays.sort(c1);
            Arrays.sort(c2);
            for (int i = 0; i < count; i++) {
                if (c1[i] != c2[i]) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
}

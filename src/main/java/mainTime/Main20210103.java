package mainTime;

import java.util.*;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20210103 {

    //    [1,3],[2,2],[3,1]
//    [5,10],[2,5],[4,7],[3,9]
//    [149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234]
    public static void main(String[] args) {
//        System.out.println(maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 50));
        System.out.println(countPairs(new int[]{149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234}));
//        System.out.println(waysToSplit(new int[]{1,2,2,2,5,0}));
    }

    public static int waysToSplit(int[] nums) {
        long z = 10 * 10 * 10 * 10 * 10 * 10 * 10 + 7;
        long result = 0;
        int len = nums.length;
        int rightP = len - 1;
        int leftP = rightP - 1;
        int sum = 0;
        int right = nums[rightP];
        int mid = nums[leftP];
        for (int num : nums) {
            sum += num;
        }
        int left = sum - right - mid;
        while (rightP > 1) {
            if (leftP <= 0 && mid > right) {
                rightP--;
                if (rightP<=1){
                    continue;
                }
                right += nums[rightP];
                leftP = rightP - 1;
                mid = nums[leftP];
                left = sum - right - mid;
                continue;
            }
            if (left <= mid && mid <= right) {
                result++;
                if (result >= z) {
                    result -= z;
                }
            }
            leftP--;
            if (leftP <= 0) {
                continue;
            }
            mid += nums[leftP];
            left = sum - right - mid;
        }
        return (int) result;
    }

    public static int countPairs(int[] deliciousness) {
        long z = 10 * 10 * 10 * 10 * 10 * 10 * 10 + 7;
        HashSet<Integer> set = new HashSet<>();
        long result = 0;
        int c2 = 1;
        for (int i = 1; i <= 22; i++) {
            set.add(c2);
            c2 = c2 * 2;
        }
        Map<Integer, Integer> valueCountMap = new HashMap<>();
        for (int i : deliciousness) {
            Integer count = valueCountMap.getOrDefault(i, 0);
            count++;
            valueCountMap.put(i, count);
        }
        Set<Integer> keys = valueCountMap.keySet();
        for (Integer key : keys) {
            Integer count = valueCountMap.get(key);
            for (Integer target : set) {
                if (target - key == key) {
                    result +=1L *  count * (count - 1) / 2;
                } else {
                    Integer cc = valueCountMap.getOrDefault(target - key, 0);
                    result +=1L *  cc * count;
                }
                if (result >= z) {
                    result -= z;
                }
            }
            valueCountMap.put(key, 0);
        }
        return (int) result;
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] box : boxTypes) {
            int value = box[1];
            int count = box[0];
            Integer c = map.getOrDefault(value, 0);
            c += count;
            map.put(value, c);
        }
        while (!map.isEmpty() && truckSize > 0) {
            Map.Entry<Integer, Integer> entry = map.pollLastEntry();
            int value = entry.getKey();
            int count = entry.getValue();
            if (count > truckSize) {
                result += value * truckSize;
                truckSize = 0;
            } else {
                result += value * count;
                truckSize -= count;
            }
        }
        return result;
    }
}

package mainTime;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20200117 {

    public static void main(String[] args) {
//        System.out.println(countGoodRectangles(new int[][]{{5,12}}));
        System.out.println(tupleSameProduct(new int[]{2}));
    }

    public static int tupleSameProduct(int[] nums) {
        int len = nums.length;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int n1 = nums[i];
            for (int j = i + 1; j < len; j++) {
                int n2 = nums[j];
                int n = n1 * n2;
                Integer count = map.getOrDefault(n, 0);
                count++;
                map.put(n, count);
            }
        }
        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            Integer count = map.get(integer);
            result += (count * (count - 1)) * 2 * 2;
        }
        return result;
    }

    public static int countGoodRectangles(int[][] rectangles) {
        int count = 0;
        int k = 0;
        for (int[] rectangle : rectangles) {
            int l = rectangle[0];
            int w = rectangle[1];
            int min = Math.min(l, w);
            if (min > k) {
                k = min;
                count = 1;
            } else if (min == k) {
                count++;
            }
        }
        return count;
    }
}

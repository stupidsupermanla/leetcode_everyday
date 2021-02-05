package mainTime;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20201115 {

    public static void main(String[] args) {
//        OrderedStream orderedStream = new OrderedStream(5);
//        List<String> l1 = orderedStream.insert(3, "cc");
//        List<String> l2 = orderedStream.insert(1, "aa");
//        List<String> l3 = orderedStream.insert(2, "bb");
//        List<String> l4 = orderedStream.insert(5, "ee");
//        List<String> l5 = orderedStream.insert(4, "dd");
        System.out.println(minOperations(new int[]{6285,2511,3617,8040,6970,8187,5617,7665,5069,875,3570,378,6556,1147,8616,3140,561,2875,5087,1372,2617,756,9076,1381,5428,498,1386,6984,5624,7908,5724,9921,4368,7036,92,4584,2654,2942,9947,9832,9969,9965,9991,9999,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,9992,10000,9985,8145,8244,4960,7560,7757,3981,8841,3482,2188,3475,1594,5101,4404,9679,3500,6984,5108,7258,9696,702,9031,2502,2326,5099,4767,7164,9432,2084,5294,7382,7564,809}, 842910));
    }

    public static int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < x) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        get(nums, 0, nums.length - 1, map, 0, x, 0);
        return map.getOrDefault(x, -1);
    }
static  boolean flag=false;
    private static void get(int[] nums, int start, int end, Map<Integer, Integer> map, int i, int x, int index) {
        if (flag){
            return;
        }
        if (i == x) {
            flag=true;
            return ;
        }
        if (start > end) {
            return;
        }
        int i1 = nums[start] + i;
        if (i1 > x) {
            return;
        }
        map.put(i1, Math.min(index + 1, map.getOrDefault(i1, Integer.MAX_VALUE)));
        get(nums, start + 1, end, map, i1, x, index + 1);
        int i2 = nums[end] + i;
        if (i2 > x) {
            return;
        }
        map.put(i2, Math.min(index + 1, map.getOrDefault(i2, Integer.MAX_VALUE)));
        get(nums, start, end - 1, map, i2, x, index + 1);
    }


}

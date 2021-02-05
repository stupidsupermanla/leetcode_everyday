package mainTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20201220 {

    public static void main(String[] args) {
//        System.out.println(reformatNumber("1-23-45 6"));
//        System.out.println(maxResult(new int[]{1}, 1));
        System.out.println(maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
    }


    public static int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(dp[0], 0);
        for (int i = 1; i < nums.length; i++) {
            Map.Entry<Integer, Integer> maxEntry = map.lastEntry();
            while (i - maxEntry.getValue() > k) {
                map.pollLastEntry();
                maxEntry = map.lastEntry();
            }
            int max = maxEntry.getKey();
            dp[i] = max + nums[i];
            map.put(dp[i], i);
        }
        return dp[nums.length - 1];
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int max = 0;
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            int index = list.indexOf(num);
            if (index >= 0) {
                max = Math.max(max, sum);
                for (int j = 0; j <= index; j++) {
                    sum -= list.get(0);
                    list.remove(0);
                }
            }
            sum += num;
            list.add(num);
        }
        return Math.max(sum, max);
    }

    public static String reformatNumber(String number) {
        number = number.replaceAll(" ", "").replaceAll("-", "");
        int len = number.length();
        StringBuilder result = new StringBuilder();
        while (number.length() > 3) {
            result.append(number, 0, 3).append("-");
            number = number.substring(3);
        }
        result.append(number);
        if (len % 3 == 1) {
            int index = result.lastIndexOf("-");
            result.replace(index, index + 1, "");
            result.insert(result.length() - 2, "-");
        }
        return result.toString();
    }
}

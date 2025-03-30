package mainTime;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main20250116 {

    public static void main(String[] args) {
        minimumSubarrayLength(new int[]{32,2,24,1},35);
    }

    public static int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int value = 0;
            for (int j = i; j < n; j++) {
                value |= nums[j];
                if (value >= k) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

package mainTime;

public class Main20250321 {

    public static void main(String[] args) {

    }

    public long maximumOr(int[] nums, int k) {
        int len = nums.length;

        long[] suf = new long[len + 1];
        for (int i = len-1; i > 0; i--) {
            suf[i] = suf[i + 1] | nums[i];
        }
        long res = 0, pre = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, pre | ((long) nums[i] << k) | suf[i + 1]);
            pre |= nums[i];
        }
        return res;

    }
}

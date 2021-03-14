package mainTime;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20210307 {

    public static void main(String[] args) {
        //       System.out.println(checkOnesSegment("110"));
        System.out.println(minElements(new int[]{-1, 0, 1, 1, 1}, 1, 771843707));
    }

    public static int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum == (long) goal) {
            return 0;
        }
        long n = Math.abs(goal - sum);
        return (int) (n / limit + (n % limit == 0 ? 0 : 1));
    }

    public static boolean checkOnesSegment(String s) {
        boolean isHaveZero = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (isHaveZero) {
                    return false;
                }
            } else {
                isHaveZero = true;
            }
        }
        return true;
    }
}

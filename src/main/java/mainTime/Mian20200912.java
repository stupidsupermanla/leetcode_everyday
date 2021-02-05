package mainTime;

import java.util.Arrays;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Mian20200912 {

    public static void main(String[] args) {
//        System.out.println(calculate("AB"));
        System.out.println(breakfastNumber(new int[]{10,20,5}, new int[]{5,5,2}, 15));
    }

//    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
//        int m = 100000007;
//        Arrays.sort(staple);
//        Arrays.sort(drinks);
//        int result = 0;
//        int j = drinks.length - 1;
//        for (int i = 0; i < staple.length; i++) {
//            int temp = staple[i];
//            if (temp > x) {
//                break;
//            }
//            while (temp + drinks[j] > x) {
//                j--;
//            }
//            result += j+1;
//            if (result >= m) {
//                result -= m;
//            }
//        }
//        return result;
//    }


    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
        int m = 100000007;
//        Arrays.sort(staple);
        Arrays.sort(drinks);
        int result = 0;
        for (int i = 0; i < staple.length; i++) {
            int temp = staple[i];
            int search = findMin(drinks, x - temp,0,drinks.length-1);
            result += search + 1;
            if (result >= m) {
                result -= m;
            }

//            for (int j = 0; j < drinks.length; j++) {
//                if (temp + drinks[j] <= x) {
//                    result++;
//                    if (result >= m) {
//                        result = 0;
//                    }
//                } else {
//                    break;
//                }
//            }
        }
        return result;
    }

    private static int findMin(int[] nums, int n, int l, int r) {
        if (l == r) {
            if (n > nums[l]) {
                return l;
            }
            return l - 1;
        }
        if (r - l == 1) {
            if (n >= nums[r]) {
                return r;
            }
            if (n >= nums[l]) {
                return l;
            }
            return l - 1;
        }
        int mid = l + (r - l) / 2;
        if (n >= nums[mid]) {
            return findMin(nums, n, mid + 1, r);
        }
        return findMin(nums, n, l, mid - 1);
    }

    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (right + left) / 2;
        while (left < right - 1) {
            if (nums[mid] <= target) {
                left = mid;
            } else if (nums[mid] > target) {
                right = mid;
            }
            mid = (right + left) / 2;
        }
        if (nums[left] <= target) {
            if (nums[left + 1] <= target) {
                return left + 1;
            }
            return left;
        } else {
            return left - 1;
        }
    }

    public static int calculate(String s) {
        int x = 1, y = 0;
        String[] ss = s.split("");
        for (String z : ss) {
            if ("A".equals(z)) {
                x = A(x, y);
            }
            if ("B".equals(z)) {
                y = B(x, y);
            }
        }
        return x + y;

    }

    public static int A(int x, int y) {
        return 2 * x + y;
    }

    public static int B(int x, int y) {
        return 2 * y + x;
    }
}

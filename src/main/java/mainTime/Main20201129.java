package mainTime;

import java.util.Stack;
import java.util.TreeSet;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20201129 {

    public static void main(String[] args) {
//        System.out.println(maximumWealth(new int[][]{{1, 5}, {2, 7}, {3, 4}}));
        int[] ints = mostCompetitive(new int[]{3,5,2,6}, 2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] mostCompetitive(int[] nums, int k) {

        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            //当前元素比队尾元素小，将队尾元素出栈
            //此处需要另外判断数组剩余长度够不够填满栈，不然最后答案长度可能会小于k
            while (nums[i] < stack.peek() && k - stack.size() + 1 < len - i) {
                stack.pop();
            }
            if (stack.size() < k + 1) {
                stack.add(nums[i]);
            }
        }

        int[] ret = new int[k];

        while (k > 0) {
            ret[--k] = stack.pop();
        }

        return ret;
    }


//    public static int[] mostCompetitive(int[] nums, int k) {
//        num = new ArrayList<>(k);
//        len = k;
//        getNum(nums, 0);
//        Integer integer = set.pollFirst();
//        int[] result = new int[k];
//        for (int i = 0; i < k; i++) {
//            result[k - i-1] = integer % 10;
//            integer=integer/10;
//        }
//        return result;
//    }
//    static TreeSet<Integer> set = new TreeSet<>();
//    static List<Integer> num;
//    static int len;
//    private static void getNum(int[] nums, int index) {
//        if (num.size() == len) {
//            StringBuilder s = new StringBuilder();
//            for (int i : num) {
//                s.append(i);
//            }
//            set.add(Integer.valueOf(s.toString()));
//            return;
//        }
//        if (index >= nums.length) {
//            return;
//        }
//        num.add(nums[index]);
//        getNum(nums, index + 1);
//        num.remove(num.size() - 1);
//        getNum(nums, index + 1);
//    }

    public static int maximumWealth(int[][] accounts) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] account : accounts) {
            int c = 0;
            for (int i : account) {
                c += i;
            }
            set.add(c);
        }
        return set.isEmpty() ? 0 : set.pollLast();
    }
}

package mainTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20210207 {

    public static void main(String[] args) {
        System.out.println(check(new int[]{2, 1, 3, 4}));
//        System.out.println(maximumScore(0, 0, 6));
//"jvjjjjjjvjjvjvjjjvjvjjjj"
//"jjjjjjvjjjjjjvjjjjv"
//        System.out.println(largestMerge("jvjjjjjjvjjvjvjjjvjvjjjj", "jjjjjjvjjjjjjvjjjjv"));
//        System.out.println(minAbsDifference(new int[]{7,-9,15,-2}, -5));
    }

  static   long min = Long.MAX_VALUE;
   static long g;
    public static int minAbsDifference(int[] nums, int goal) {
        g = goal;
        getSubArray(nums, nums.length);
        return (int) min;
    }

    private static void getSubArray(int[] arr,int length) {
        int mark=0;
        int nEnd=1<<length;
        for (mark=0;mark<nEnd;mark++) {
            ArrayList<Integer> aList=new ArrayList<>();
            for (int i=0;i<length;i++) {
                if (((1<<i)&mark)!=0) {
                    aList.add(arr[i]);
                }
            }
            long sum = 0;
            for (Integer integer : aList) {
                sum += integer;
            }
            sum = Math.abs(g-sum);
            min = Math.min(min, sum);
        }
    }


    static List<Integer> temp = new ArrayList<Integer>();

    public static void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            long sum = 0;
            for (Integer integer : temp) {
                sum += integer;
            }
            sum = Math.abs(g-sum);
            min = Math.min(min, sum);
            return;
        }
        temp.add(nums[cur]);
        dfs(cur + 1,  nums);
        temp.remove(temp.size() - 1);
        dfs(cur + 1,  nums);

    }

    public static int maximumScore(int a, int b, int c) {
        int count = 0;
        int[] nums = new int[]{a, b, c};
        Arrays.sort(nums);
        while (nums[0] != 0 || nums[1] != 0) {
            nums[2]--;
            nums[1]--;
            count++;
            Arrays.sort(nums);
        }
        return count;
    }

    public static String largestMerge(String word1, String word2) {
        StringBuilder merge = new StringBuilder();
        while (word1.length() > 0 || word2.length() > 0) {
            if (word1.length() == 0) {
                merge.append(word2.charAt(0));
                word2 = word2.substring(1);
                continue;
            }
            if (word2.length() == 0) {
                merge.append(word1.charAt(0));
                word1 = word1.substring(1);
                continue;
            }
            if (word1.charAt(0) > word2.charAt(0)) {
                merge.append(word1.charAt(0));
                word1 = word1.substring(1);
            } else if (word1.charAt(0) < word2.charAt(0)) {
                merge.append(word2.charAt(0));
                word2 = word2.substring(1);
            } else {
                char temp = word1.charAt(0);
                int c = 1;
                boolean flag = false;
                while (word1.length() > c && word2.length() > c) {
                    if (word1.charAt(c) == word2.charAt(c)) {
                        c++;
                        continue;
                    } else if (word1.charAt(c) > word2.charAt(c)) {
                        merge.append(word1.charAt(0));
                        word1 = word1.substring(1);
                        flag = true;
                        break;
                    } else {
                        merge.append(word2.charAt(0));
                        word2 = word2.substring(1);
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
                if (word1.length() <= c) {
                    merge.append(word2.charAt(0));
                    word2 = word2.substring(1);
                    continue;
                }
                if (word2.length() <= c) {
                    merge.append(word1.charAt(0));
                    word1 = word1.substring(1);
                    continue;
                }
            }
        }
        return merge.toString();
    }

    public static boolean check(int[] nums) {
        int len = nums.length;
        int[] temp = Arrays.copyOf(nums,len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                temp[j] = nums[i + j >= len ? i + j - len : i + j];
            }
            if (checkPossibility(temp)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return true;
        }
        int temp = nums[0];
        for (int i = 1; i < len; i++) {
            if (temp > nums[i]) {
               return false;
            } else {
                temp = nums[i];
            }
        }
        return true;
    }
}

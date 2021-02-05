package mainTime;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20201212 {

    public static void main(String[] args) {
//        int[] ints = getSumAbsoluteDifferences(new int[]{1,3});
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
        System.out.println(countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}));

    }

    //对于一个非递减有序数组里的一个位置i而言
    //
    //位于它左边部分的位置j对它的答案的贡献是 nums[i] - nums[j]
    //位于它右边部分的位置j对它的答案的贡献是 nums[j] - nums[i];
    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n      = nums.length;
        int[] presum = new int[n+1];
        int res[]  = new int[n];
        for(int i=0;i<n;i++){
            presum[i+1] += (presum[i] + nums[i]);                           //偏移了一位,psum[i]存放前i个值的和
        }
        for(int i=0;i<n;i++){
            int x = i, y = n - x - 1;
            int leftSum = presum[i], rightSum = presum[n] - presum[i+1];
            int lpart = x * nums[i] - leftSum;
            int rpart = rightSum - y * nums[i];
            res[i] = lpart + rpart;
        }
        return res;
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int result = 0;
        Set<Character> set=new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        for (String word : words) {
            boolean flag = true;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (!set.contains(c)){
                    flag=false;
                    break;
                }
            }
            if (flag){
                result++;
            }
        }
        return result;
    }
}

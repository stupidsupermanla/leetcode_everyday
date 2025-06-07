package review;

public class Kspx {

    public static void kspx(int[] nums){
        doKspx(nums,0,nums.length-1);
    }

    public static void doKspx(int[] nums,int start,int end){
        if (start<end) {
            int index = getIndex(nums, start, end);
            doKspx(nums, start, index-1);
            doKspx(nums, index + 1, end);
        }
    }

    public static int getIndex(int[] nums,int start,int end){
        int temp = nums[start];
        while (start<end){
            while (start<end && temp>nums[end]){
                end--;
            }
            nums[start]=nums[end];
            while (start<end && temp<nums[start]){
                start++;
            }
            nums[end]=nums[start];
        }
        nums[start]= temp;
        return start;
    }

}

package review;

/**
 * 215. 数组中的第K个最大元素
 */
public class lc215 {
    public static void main(String[] args) {
        int[] ints = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(ints, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int min = 0;
        int max = len-1;
        int index = getIndex(nums, min, max);
        int target = len -k;
        while (index !=target){
            if (index>target){
                max = index-1;
            }else {
                min = index+1;
            }
            index = getIndex(nums,min,max);
        }
        return nums[index];
    }

    public static int getIndex(int[] nums,int min,int max){
            int temp = nums[min];
            while (min<max){
                while (min<max && nums[max]>=temp){
                    max--;
                }
                nums[min]=nums[max];
                while (min<max && nums[min]<=temp){
                    min++;
                }
                nums[max]=nums[min];
            }
            nums[min] = temp;
            return min;
    }
}

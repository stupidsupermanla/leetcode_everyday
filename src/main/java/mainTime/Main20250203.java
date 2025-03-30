package mainTime;

public class Main20250203 {

    public static void main(String[] args) {
        String s = "zazazr";
        //System.out.println(s.substring(0,s.length()-1));
        System.out.println(validPalindrome(s));

    }

    public int search1(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0]==target?0:-1;
        }
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target >= nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 81 二分查找
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int len  = nums.length;
        if (len ==0){
            return false;
        }
        if (len==1){
            return nums[0]==target;
        }
        int left = 0,right = len-1;
        while (left<right){
            int mid = (left+right) /2;
            if (nums[mid]==target || nums[left] == target || nums[right]==target){
                return true;
            }
            if (nums[left]==nums[mid] && nums[right]==nums[mid]){
                left++;
                right--;
            }else {
                if (nums[left]<=nums[mid]){
                    if (target>=nums[left] && target<=nums[mid]){
                        right = mid-1;
                    }else {
                        left=mid+1;
                    }
                }else {
                    if (target<=nums[right] && target>=nums[mid]){
                        left=mid+1;
                    }else {
                        right = mid-1;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 598
     * 取x和y的最小值相乘即可
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public int maxCount(int m, int n, int[][] ops) {
        // 先取x的最小值 和 y 的最小值
        int maxX = m;
        int maxY = n;
        for (int[] op : ops) {
            int x= op[0];
            int y = op[1];
            maxX = Math.min(maxX,x);
            maxY = Math.min(maxY,y);
        }
        return maxY*maxY;
    }

    /**
     * 680
     * 第一次使用substring减首尾递归的方式来做，超时了；思路是一致的substring比较耗时
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        int left = 0,right =s.length()-1;
        while (left<right){
            if (s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            } else {
                return validPalindrome(s,left+1,right) || validPalindrome(s,left,right-1);
            }
        }

       return true;
    }

    public static boolean validPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; ++i, --j) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }



}

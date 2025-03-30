package mainTime;

import java.util.PriorityQueue;

public class Main20250118 {

    public static void main(String[] args) {
      //  System.out.println(largestGoodInteger("666"));
        System.out.println('a'-'A');
        System.out.println(countKeyChanges("AaAaAaaA"));
        maxConsecutive(6,8,new int[]{7,6,8});
    }

    public static int maxConsecutive(int bottom, int top, int[] special) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : special) {
            queue.add(i);
        }
        int result = 0;
        int specialNum1 = queue.poll();
        result = Math.max(result,specialNum1-bottom);
        while (!queue.isEmpty()){
            Integer special2 = queue.poll();
            result = Math.max(result,special2-specialNum1-1);
            specialNum1 = special2;
        }
        result = Math.max(result,top-specialNum1);
        return result;
    }

    public static int countKeyChanges(String s) {
        int result = 0;
        char temp = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char t = s.charAt(i);
            if (temp==t || temp+32==t||temp-32==t){

            }else {
                result++;
                temp=t;
            }
        }
        return result;
    }

    public static String largestGoodInteger(String num) {
        int len = num.length();
        String result = "";
        for (int i = 0; i < len-2; i++) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(i+1);
            char c3 = num.charAt(i+2);
            if (c1==c2&&c2==c3){
                String goodNum = c1 +String.valueOf(c2)+ c3;
                result = goodNum.compareTo(result)>0?goodNum:result;
            }
        }
        return result;
    }

    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        int result = 0;
        long left=0;
        for (int i = 0; i < nums.length-1; i++) {
            int num = nums[i];
            left+=num;
            sum-=num;
            if (left>=sum){
                result++;
            }
        }

        return result;
    }
}

package review;

import java.util.Deque;
import java.util.LinkedList;

public class Jys {

    public static void main(String[] args) {

    }

    public static int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int len = height.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            int h = height[i];
            while (!stack.isEmpty() && h >height[stack.peek()]){
                Integer pop = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                result +=(i-stack.peek()-1) * (Math.min(height[stack.peek()],h) -height[pop]);
            }
            stack.push(i);
        }
        return result;
    }
}

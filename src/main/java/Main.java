import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
        System.out.println(isHuiWen(121));
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();

        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }



    public static boolean isHuiWen(int x) {
        y =x;
        return dfs(x);
    }
    static int y;
    private static boolean dfs(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        if (dfs(x / 10) && x % 10 == y % 10) {
            y /= 10;
            return true;
        } else {
            return false;
        }
    }
}

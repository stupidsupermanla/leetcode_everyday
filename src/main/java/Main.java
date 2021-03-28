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

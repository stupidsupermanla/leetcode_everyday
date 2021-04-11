package mainTime;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @Author hudi
 * @Date 2021/4/11
 * @Version 1.0
 **/
public class Main20210411 {

    public static void main(String[] args) {
//        System.out.println(findTheWinner(5, 2));
// [0,0,0,0,2,1,2,0,2,2,3,3,3,0,0,1,1,3,0,0,0,1,2,2,1,2,1,3,2,2,3,1,3,0,1,1,1,3,0,0,0,2,0,2,0,3,1,2,3,3,2,2,2,0,0,0,1,0,0,0,0,3,0,0,0,3,0,2,1,2,3,1,0,3,3,2,0,1,1,0,1,0,2,2,2,1,3,0,3,0,2,1,1,3,1,0,1,2,2,0,0]
        System.out.println(minSideJumps(new int[]{}));
    }

    public static int minSideJumps(int[] obstacles) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        int len = obstacles.length;
        for (int i = 0; i < len; i++) {
            int obstacle = obstacles[i];
            if (obstacle == 1) {
                q1.offer(i);
            }
            if (obstacle == 2) {
                q2.offer(i);
            }
            if (obstacle == 3) {
                q3.offer(i);
            }
        }
//
        int num = 0;
        int n = 0;
        int p = 2;
        if (q2.isEmpty()) {
            n = len;
        } else {
            n = q2.peek() - 1;
        }
        while (n < len) {
            while (!q1.isEmpty() && q1.peek() < n) {
                q1.poll();
            }
            while (!q2.isEmpty() && q2.peek() < n) {
                q2.poll();
            }
            while (!q3.isEmpty() && q3.peek() < n) {
                q3.poll();
            }
            if (p == 1) {
                if (q2.isEmpty() || q3.isEmpty()) {
                    num++;
                    n = len;
                } else {
                    if (q2.peek() > q3.peek()) {
                        n = q2.peek() - 1;
                        num++;
                        p = 2;
                    } else {
                        n = q3.peek() - 1;
                        num++;
                        p = 3;
                    }
                }
            } else if (p == 2) {
                if (q1.isEmpty() || q3.isEmpty()) {
                    num++;
                    n = len;
                } else {
                    if (q1.peek() > q3.peek()) {
                        n = q1.peek() - 1;
                        num++;
                        p = 1;
                    } else {
                        n = q3.peek() - 1;
                        num++;
                        p = 3;
                    }
                }
            } else {
                if (q1.isEmpty() || q2.isEmpty()) {
                    num++;
                    n = len;
                } else {
                    if (q1.peek() > q2.peek()) {
                        n = q1.peek() - 1;
                        num++;
                        p = 1;
                    } else {
                        n = q2.peek() - 1;
                        num++;
                        p = 2;
                    }
                }
            }

        }
        return num;
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int num = 0;
        while (list.size() > 1) {
            int count = (k % list.size()) + num;
            count = count > list.size() ? count - list.size() : count;
            int postion = count - 1 >= 0 ? count - 1 : list.size() - 1;
            list.remove(postion);
            num = postion;
        }
        return list.get(0);
    }

    public static int arraySign(int[] nums) {
        int result = 1;
        for (int num : nums) {
            if (num < 0) {
                result *= -1;
            } else if (num == 0) {
                return 0;
            }
        }
        return result;
    }
}

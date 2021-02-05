package mainTime;

import java.util.PriorityQueue;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20210124 {

    public static void main(String[] args) {
//        System.out.println(maximumTime("?4:??"));
//        System.out.println(5 ^ 3 ^ 3 ^ 3);
        System.out.println(kthLargestValue(new int[][]{{5,2},{1,6}},1));
    }


    public static String maximumTime(String time) {
        String[] d2 = new String[]{"2", "3", ":", "5", "9"};
        String[] d = new String[]{"1", "9", ":", "5", "9"};
        while (time.indexOf("?") >= 0) {
            int index = time.indexOf("?");
            if (index <= 1) {
                if (index == 0 || time.charAt(0) == '2') {
                    if (time.charAt(1) != '?' && time.charAt(1) > '3') {
                        time = time.substring(0, index) + d[index] + time.substring(index + 1);
                    } else {
                        time = time.substring(0, index) + d2[index] + time.substring(index + 1);
                    }
                } else {
                    time = time.substring(0, index) + d[index] + time.substring(index + 1);

                }
            } else {
                time = time.substring(0, index) + d[index] + time.substring(index + 1);
            }
        }
        return time;
    }

    public static int kthLargestValue(int[][] matrix, int k) {
        int ys = matrix.length;
        int xs = matrix[0].length;
        int[][] matrixR = new int[ys][xs];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < ys; i++) {
            for (int j = 0; j < xs; j++) {
                if (i == 0 && j == 0) {
                    matrixR[i][j] = matrix[i][j];
                } else if (i == 0) {
                    matrixR[i][j] = matrix[i][j] ^ matrixR[i][j - 1];
                } else if (j == 0) {
                    matrixR[i][j] = matrix[i][j] ^ matrixR[i - 1][j];
                } else {
                    matrixR[i][j] = matrix[i][j] ^ matrixR[i - 1][j] ^ matrixR[i - 1][j - 1] ^ matrixR[i][j - 1];
                }
                queue.add(matrixR[i][j]);
            }
        }
        int result = -1;
        for (int i = 0; i < k; i++) {
            result = queue.poll();
        }
        return result;
    }
}

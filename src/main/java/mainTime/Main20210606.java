package mainTime;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description
 * @Author hudi
 * @Date 2021/6/6
 * @Version 1.0
 **/
public class Main20210606 {

    public static void main(String[] args) {
//        System.out.println(reductionOperations(new int[]{1,1,2,2,3}));
        System.out.println(minWastedSpace(new int[]{3,5,8,10,11,12}, new int[][]{{12}, {11,9},{10,5,14}}));
    }

    // 思路有问题，没做出来
    public static int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        long min = -1;
        for (int[] box : boxes) {
            long count = 0;
            Arrays.sort(box);
            if (box[box.length-1]<packages[packages.length-1]){
                continue;
            }
            int pIndex = 0;
            for (int i : box) {
                while (pIndex<packages.length && packages[pIndex]<=i){
                    count+=i-packages[pIndex];
                    pIndex++;
                }
            }
            if (count >=0){
                if (min<0){
                    min = count;
                }else {
                    min=Math.min(count,min);
                }
            }
        }
        return (int) (min % 1000000007);
    }

    public static int reductionOperations(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
        }
        int count = 0;
        while (map.size() > 1) {
            Map.Entry<Integer, Integer> entry1 = map.pollLastEntry();
            Integer c = entry1.getValue();
            count += c;
            Map.Entry<Integer, Integer> entry2 = map.pollLastEntry();
            map.put(entry2.getKey(), entry2.getValue() + c);
        }
        return count;
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (eq(mat, target)) {
                return true;
            }
            rotate(mat);
        }
        return false;
    }

    private static boolean eq(int[][] mat1, int[][] mat2) {
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                if (mat1[i][j] != mat2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

}

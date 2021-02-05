package mainTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20200919 {

    public static void main(String[] args) {
//        System.out.println(paintingPlan(5, 1));
//        System.out.println(paintingPlan(5, 2));
//        System.out.println(paintingPlan(5, 3));
//        System.out.println(paintingPlan(5, 4));
//        System.out.println(paintingPlan(5, 5));
//        System.out.println(paintingPlan(5, 6));
//        System.out.println(paintingPlan(5, 7));
//        System.out.println(paintingPlan(5, 8));
//        System.out.println(paintingPlan(5, 9));
//        System.out.println(paintingPlan(5, 10));
//        System.out.println(paintingPlan(5, 11));
//        System.out.println(paintingPlan(5, 12));
//        System.out.println(paintingPlan(5, 13));
//        System.out.println(paintingPlan(5, 14));
//        System.out.println(paintingPlan(5, 15));
//        System.out.println(paintingPlan(5, 16));
//        System.out.println(paintingPlan(5, 17));
//        System.out.println(paintingPlan(5, 18));
//        System.out.println(paintingPlan(5, 19));
//        System.out.println(paintingPlan(5, 20));
//        System.out.println(paintingPlan(5, 21));
//        System.out.println(paintingPlan(5, 22));
//        System.out.println(paintingPlan(5, 23));
//        System.out.println(paintingPlan(5, 24));
//        System.out.println(paintingPlan(5, 25));
        for (int i = 0; i < 36; i++) {
            System.out.println(paintingPlan(6, i)+" "+i);

        }


    }

    public static int paintingPlan(int n, int k) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            int sum = i * n;
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (j > 0) {
                    sum += n - i;
                }
                if (sum == k) {
                    if (i == n || j == n) {
                        return 1;
                    }
                    list.add(new int[]{i, j});
                }
            }
        }
        int result = 0;
        for (int[] ints : list) {
            int x = ints[0];
            int y = ints[1];
            int xs = x == 0 ? 0 : 1;
            int ys = y == 0 ? 0 : 1;
            for (int i = 0; i < x; i++) {
                xs *= (n - i);
                xs /= (i + 1);
            }
            for (int i = 0; i < y; i++) {
                ys *= (n - i);
                ys /= (i + 1);
            }
            result += xs + ys;
        }
        return result;
    }



        public int paintingPlan1(int n, int k) {
            Map<String, Boolean> map = new HashMap<>();
            paint(n, n, k, new int[n][n], map, new boolean[n], new boolean[n]);
            return map.size();
        }

        private void paint(int m, int n, int k, int[][] pat, Map<String, Boolean> map,
                           boolean[] usex, boolean[] usey) {
            if(k == 0){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < pat.length; i++){
                    for(int j = 0; j < pat.length; j++){
                        sb.append(pat[i][j] > 0);
                    }
                }
                map.put(sb.toString(), true);
                return;
            }
            if((m < 0 || n < 0) && k > 0){
                return;
            }
            if(k < m && k < n){
                return;
            }
            if(k >= n){
                for(int i = 0; i < usex.length; i++){
                    if(usex[i]){
                        continue;
                    }
                    usex[i] = true;
                    for(int j = 0; j < usex.length; j++){
                        pat[i][j]++;
                    }
                    paint(m-1, n, k-n, pat, map, usex, usey);
                    for(int j = 0; j < usex.length; j++){
                        pat[i][j]--;
                    }
                    usex[i] = false;
                }
            }
            if(k >= m){
                for(int i = 0; i < usey.length; i++){
                    if(usey[i]){
                        continue;
                    }
                    usey[i] = true;
                    for(int j = 0; j < usey.length; j++){
                        pat[j][i]++;
                    }

                    paint(m, n-1, k-m, pat, map, usex, usey);
                    for(int j = 0; j < usey.length; j++){
                        pat[j][i]--;
                    }
                    usey[i] = false;
                }
            }


    }
}

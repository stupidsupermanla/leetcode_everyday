package mainTime;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20210109 {

    public static void main(String[] args) {
//        System.out.println(totalMoney(20));
//        "kbckbbaaeabsbalaababbjrbabbhajabbaagaqabazapgfbmbdabkajzbpabobaaaakaababbbbbaabrbbablfqaaaavabbbaabaaubbabblvaaacwbbxbcubaabmbabmraaabbzyabaakaabbpbbb"
//486
//8391

        System.out.println(maximumGain("kbckbbaaeabsbalaababbjrbabbhajabbaagaqabazapgfbmbdabkajzbpabobaaaakaababbbbbaabrbbablfqaaaavabbbaabaaubbabblvaaacwbbxbcubaabmbabmraaabbzyabaakaabbpbbb", 486, 8391));
    }

    public static int maximumGain(String s, int x, int y) {
        int sum = 0;
        int index = 0;
        if (x > y) {
            while (index < s.length()) {
                int ac = 0;
                int bc = 0;
                while (index < s.length() && s.charAt(index) == 'a') {
                    index++;
                    ac++;
                }
                while (index < s.length() && s.charAt(index) == 'b') {
                    index++;
                    bc++;
                }
                if (ac > 0 && bc > 0) {
                    if (ac > bc) {
                        sum += x * bc;
                        s = s.substring(0, index - bc * 2) + s.substring(index);
                    } else {
                        sum += x * ac;
                        s = s.substring(0, index - bc - ac) + s.substring(index - bc + ac);
                    }
                    index = index - bc -ac;
                }
                if (ac > 0 || bc > 0) {
                    continue;
                }
                index++;
            }
            index = 0;
            while (index < s.length()) {
                int ac = 0;
                int bc = 0;
                while (index < s.length() && s.charAt(index) == 'b') {
                    index++;
                    bc++;
                }
                while (index < s.length() && s.charAt(index) == 'a') {
                    index++;
                    ac++;
                }
                if (ac > 0 && bc > 0) {
                    if (bc > ac) {
                        sum += y * ac;
                        s = s.substring(0, index - ac * 2) + s.substring(index);
                    } else {
                        sum += y * bc;
                        s = s.substring(0, index - ac - bc) + s.substring(index - ac + bc);
                    }
                    index = index - bc -ac;
                }
                if (ac > 0 || bc > 0) {
                    continue;
                }
                index++;
            }
        } else {
            while (index < s.length()) {
                int ac = 0;
                int bc = 0;
                while (index < s.length() && s.charAt(index) == 'b') {
                    index++;
                    bc++;
                }
                while (index < s.length() && s.charAt(index) == 'a') {
                    index++;
                    ac++;
                }
                if (ac > 0 && bc > 0) {
                    if (bc > ac) {
                        sum += y * ac;
                        s = s.substring(0, index - ac * 2) + s.substring(index);
                    } else {
                        sum += y * bc;
                        s = s.substring(0, index - ac - bc) + s.substring(index - ac + bc);
                    }
                    index = index - bc -ac;

                }
                if (ac > 0 || bc > 0) {
                    continue;
                }
                index++;
            }
            index = 0;
            while (index < s.length()) {
                int ac = 0;
                int bc = 0;
                while (index < s.length() && s.charAt(index) == 'a') {
                    index++;
                    ac++;
                }
                while (index < s.length() && s.charAt(index) == 'b') {
                    index++;
                    bc++;
                }
                if (ac > 0 && bc > 0) {
                    if (ac > bc) {
                        sum += x * bc;
                        s = s.substring(0, index - bc * 2) + s.substring(index);
                    } else {
                        sum += x * ac;
                        s = s.substring(0, index - bc - ac) + s.substring(index - bc + ac);
                    }
                    index = index - bc -ac;
                }
                if (ac > 0 || bc > 0) {
                    continue;
                }
                index++;
            }
        }
        return sum;
    }

    //超时
//    public static int maximumGain(String s, int x, int y) {
//        String first = x > y ? "ab" : "ba";
//        int max = Math.max(x, y);
//        String last = x > y ? "ba" : "ab";
//        int min = Math.min(x, y);
//        int sum = 0;
//        while (s.contains("ab") || s.contains("ba")) {
//            while (s.contains(first)) {
//                int index = s.indexOf(first);
//                s = s.substring(0, index) + s.substring(index + 2);
//                sum += max;
//            }
//            while (s.contains(last)) {
//                int index = s.indexOf(last);
//                s = s.substring(0, index) + s.substring(index + 2);
//                sum += min;
//            }
//        }
//        return sum;
//    }


    public static int totalMoney(int n) {
        int init = 1;
        int temp = 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 7 == 1) {
                temp = init++;
            }
            sum += temp;
            temp++;
        }
        return sum;
    }
}

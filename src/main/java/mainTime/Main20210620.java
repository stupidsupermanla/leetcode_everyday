package mainTime;

/**
 * @Description
 * @Author hudi
 * @Date 2021/6/20
 * @Version 1.0
 **/
public class Main20210620 {

    public static void main(String[] args) {
        // System.out.println(largestOddNumber("35427"));
        System.out.println(numberOfRounds("20:00", "6:00"));
    }

    public static String largestOddNumber(String num) {
        int len = num.length();
        for (int i = len - 1; i >= 0; i--) {
            int c = num.charAt(i) - '0';
            if (c % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static int numberOfRounds(String startTime, String finishTime) {
        int result = 0;
        String[] s = startTime.split(":");
        String[] f = finishTime.split(":");
        int sh = Integer.parseInt(s[0]);
        int sm = Integer.parseInt(s[1]);
        int fh = Integer.parseInt(f[0]);
        int fm = Integer.parseInt(f[1]);
        // 玩通宵
        if (sh > fh) {
            result += (24 - sh - 1) * 4;
            result += (60 - sm) / 15;
            result += fh * 4;
            result += fm / 15;
        } else if (sh == fh && sm > fm) {
            result += (24 - sh - 1) * 4;
            result += (60 - sm) / 15;
            result += fh * 4;
            result += fm / 15;
        } else {
            result += fh * 4 + fm / 15 - sh * 4 - Math.ceil((double) sm / 15);
        }
        return result;
    }
}

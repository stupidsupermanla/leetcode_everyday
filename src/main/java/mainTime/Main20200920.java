package mainTime;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20200920 {

    public static void main(String[] args) {
//        System.out.println(sumOddLengthSubarrays(new int[]{1}));
        System.out.println(reorderSpaces(" "));
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int result = 0;
        for (int i = 1; i <= len; i++) {
            if (i % 2 == 1) {
                for (int j = 0; j <= len - i; j++) {
                    int temp = 0;
                    for (int k = 0; k < i; k++) {
                        temp += arr[j + k];
                    }
                    result += temp;
                }
            }
        }
        return result;
    }

    public static String reorderSpaces(String text) {
        List<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            }
            String temp = "";
            while (i < text.length() && Character.isLetter(text.charAt(i))) {
                temp += text.charAt(i);
                i++;
            }
            if (temp.length() > 0) {
                i--;
                list.add(temp);
            }
        }
        String result = "";
        if (list.size()==1){
            result+=list.get(0);
            for (int i = 0; i < count; i++) {
                result +=" ";
            }
            return result;
        }
        int c = count / (list.size() - 1);
        int mod = count % (list.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            result += s;
            if (i < list.size() - 1) {
                for (int j = 0; j < c; j++) {
                    result += " ";
                }
            }
        }
        for (int i = 0; i < mod; i++) {
            result += " ";
        }
        return result;
    }
}

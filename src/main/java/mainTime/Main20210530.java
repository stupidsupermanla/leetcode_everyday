package mainTime;

/**
 * @Description
 * @Author hudi
 * @Date 2021/5/30
 * @Version 1.0
 **/
public class Main20210530 {

    public static void main(String[] args) {
//        System.out.println(isSumEqual("aaa", "a", "aab"));
//        "469975787943862651173569913153377"
//3
//        System.out.println(maxValue("469975787943862651173569913153377", 3));

    }

//    public int[] assignTasks(int[] servers, int[] tasks) {
//        int len = tasks.length;
//        int[] result = new int[len];
//
//
//    }

    public static String maxValue(String n, int x) {
        int len = n.length();
        int p = len;
        if (n.startsWith("-")) {
            for (int i = 1; i < len; i++) {
                if (n.charAt(i) - '0' > x) {
                    p = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (n.charAt(i) - '0' < x) {
                    p = i;
                    break;
                }
            }
        }
        return new StringBuilder(n).insert(p, x).toString();
    }

    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        StringBuilder firstS = new StringBuilder();
        StringBuilder secondS = new StringBuilder();
        StringBuilder targetS = new StringBuilder();
        for (int i = 0; i < firstWord.length(); i++) {
            firstS.append(firstWord.charAt(i) - 'a');
        }
        for (int i = 0; i < secondWord.length(); i++) {
            secondS.append(secondWord.charAt(i) - 'a');
        }
        for (int i = 0; i < targetWord.length(); i++) {
            targetS.append(targetWord.charAt(i) - 'a');
        }
        return Integer.parseInt(firstS.toString()) + Integer.parseInt(secondS.toString()) == Integer.parseInt(targetS.toString());

    }
}

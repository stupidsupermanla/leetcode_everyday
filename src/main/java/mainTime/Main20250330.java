package mainTime;

public class Main20250330 {

    public static void main(String[] args) {
        System.out.println(addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15}));
    }

    public long minimumCost(String s) {
        long result = 0L;
        int length = s.length();
        for (int i = 1; i < length; i++) {
            if (s.charAt(i-1)!=s.charAt(i)){
                result+=Math.min(i,length-i);
            }
        }
        return result;
    }

    public static int minimizedStringLength(String s) {
        int[] chars = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            chars[s.charAt(i)-'a']++;
        }
        int result = 0;
        for (int aChar : chars) {
            if (aChar>0){
                result++;
            }
        }
        return result;
    }

    public static String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int pre = 0;
        int cur = s.length()-1 ;
        for (int i = 0; i < spaces.length; i++) {
            cur = spaces[i];
            result.append(s.substring(pre, cur).concat(" "));
            pre = cur;
        }
        result.append(s.substring(cur));
        return result.toString();
    }
}

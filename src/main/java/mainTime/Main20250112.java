package mainTime;

public class Main20250112 {

    public static void main(String[] args) {
        int[] candidates = new int[]{1, 5, 3};
        System.out.println(largestCombination(candidates));
    }

    public static int largestCombination(int[] candidates) {
        String[] array2 = new String[candidates.length];
        int maxLen = 0;
        for (int i = 0; i < candidates.length; i++) {
            String binaryString = Integer.toBinaryString(candidates[i]);
            array2[i]=binaryString;
            maxLen=Math.max(maxLen,binaryString.length());
        }
        int result = 0;
        for (int i = 0; i < maxLen; i++) {
            int len = 0;
            for (String s : array2) {
                if (i<s.length() && s.charAt(s.length()-1-i)=='1'){
                    len++;
                }
            }
            result = Math.max(result, len);
        }
        return result;
    }
}

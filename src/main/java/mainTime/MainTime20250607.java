package mainTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTime20250607 {
    public static void main(String[] args) {
        System.out.println((char) ('a' + 1));
        System.out.println(clearStars("aa*ba**"));
    }

    public static String clearStars(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int length = s.length();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            if (c == '*') {
                // 删除
                for (int j = 0; j < 26; j++) {
                    char cj = (char) ('a' + j);
                    if (map.containsKey(cj)) {
                        List<Integer> positions = map.get(cj);
                        charArray[positions.get(positions.size() - 1)] = '*';
                        positions.remove(positions.size() - 1);
                        if (positions.isEmpty()) {
                            map.remove(cj);
                        }
                        break;
                    }
                }
            } else {
                List<Integer> list = map.getOrDefault(c, new ArrayList<>());
                list.add(i);
                map.put(c, list);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            if (c!='*'){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

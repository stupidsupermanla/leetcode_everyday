package mainTime;

import java.util.*;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20210328 {

    public static void main(String[] args) {
//        System.out.println(numDifferentIntegers("a1b01c001"));
        System.out.println(reinitializePermutation(8));
//        List<List<String>> knowledge = new ArrayList<>();
//        List<String> keys1 = new ArrayList<>();
//        keys1.add("a");
//        keys1.add("bob");
//        knowledge.add(keys1);
//        List<String> keys2 = new ArrayList<>();
//        keys2.add("age");
//        keys2.add("two");
//        knowledge.add(keys2);
//
//        System.out.println(evaluate("(a)(a)(a)aaa", knowledge));
    }

    public static String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                Integer left = stack.pop();
                String key = s.substring(left + 1, i);
                String rep = map.getOrDefault(key, "?");
                result.append(rep);
            } else {
                if (stack.isEmpty()) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    public static int reinitializePermutation(int n) {
        int i = 1;
        int count = 0;
        boolean isFirst = true;
        while (i != 1 || isFirst) {
            isFirst = false;
            if (i % 2 == 0) {
                i /= 2;
            } else {
                i = n / 2 + (i - 1) / 2;
            }
            count++;
        }
        return count;
    }


    public static int numDifferentIntegers(String word) {
        StringBuilder temp = new StringBuilder();
        Set<String> set = new HashSet<>();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (c >= '0' && c <= '9') {
                temp.append(c);
            } else {
                if (temp.length() > 0) {
                    while (temp.indexOf("0") == 0) {
                        temp.delete(0, 1);
                    }
                    if (temp.length() == 0) {
                        set.add("0");
                    } else {
                        set.add(temp.toString());
                        temp = new StringBuilder();
                    }
                }
            }
        }
        if (temp.length() > 0) {
            while (temp.indexOf("0") == 0) {
                temp.delete(0, 1);
            }
            if (temp.length() == 0) {
                set.add("0");
            } else {
                set.add(temp.toString());
            }
        }
        return set.size();
    }
}

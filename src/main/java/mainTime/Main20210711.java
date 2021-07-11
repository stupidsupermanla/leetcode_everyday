package mainTime;

import java.util.*;

/**
 * @Description
 * @Author hudi
 * @Date 2021/7/11
 * @Version 1.0
 **/
public class Main20210711 {

    public static void main(String[] args) {
//        int[] concatenation = getConcatenation(new int[]{1, 2, 3});
//        for (int i : concatenation) {
//            System.out.print(i + ",");
//        }
//        System.out.println(countPalindromicSubsequence("bbcbaba"));
        System.out.println(numOfWays(5, 5));
    }

    public static int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] result = new int[2 * len];
        for (int i = 0; i < len; i++) {
            result[i] = nums[i];
            result[i + len] = nums[i];
        }
        return result;
    }

    public static int countPalindromicSubsequence(String s) {
        Map<Character, Set<Character>> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char start = s.charAt(i);
            if (map.containsKey(start)) {
                continue;
            }
            Set<Character> set = new HashSet<>();
            for (int j = len - 1; j > i; j--) {
                if (s.charAt(j) == start) {
                    for (int k = i + 1; k < j; k++) {
                        set.add(s.charAt(k));
                    }
                    break;
                }
            }
            map.put(start, set);
        }
        int result = 0;
        Set<Character> keySet = map.keySet();
        for (Character character : keySet) {
            result += map.get(character).size();
        }
        return result;
    }

    static final int MOD = 1000000007;

    public static int numOfWays(int m, int n) {
        // 预处理出所有满足条件的 type
        List<String> types = new ArrayList<>();
        if (m == 1) {
            for (int i = 0; i < 3; i++) {
                types.add(String.valueOf(i));
            }
        } else if (m == 2) {
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    if (i != j) {
                        types.add(String.valueOf(i) + j);
                    }
                }
            }
        } else if (m == 3) {
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    for (int k = 0; k < 3; ++k) {
                        if (i != j && j != k) {
                            types.add(String.valueOf(i) + j + k);
                        }
                    }
                }
            }
        } else if (m == 4) {
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    for (int k = 0; k < 3; ++k) {
                        for (int p = 0; p < 3; ++p) {
                            if (i != j && j != k && k != p) {
                                types.add(String.valueOf(i) + j + k + p);
                            }
                        }
                    }
                }
            }
        } else if (m == 5) {
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    for (int k = 0; k < 3; ++k) {
                        for (int p = 0; p < 3; ++p) {
                            for (int q = 0; q < 3; ++q) {
                                if (i != j && j != k && k != p && p != q) {
                                    types.add(String.valueOf(i) + j + k + p + q);
                                }
                            }
                        }
                    }
                }
            }
        }


        int typeCnt = types.size();
        // 预处理出所有可以作为相邻行的 type 对
        int[][] related = new int[typeCnt][typeCnt];
        if (m == 1) {
            for (int i = 0; i < typeCnt; ++i) {
                char x1 = types.get(i).charAt(0);
                for (int j = 0; j < typeCnt; ++j) {
                    char y1 = types.get(j).charAt(0);
                    if (x1 != y1) {
                        related[i][j] = 1;
                    }
                }
            }
        } else if (m == 2) {
            for (int i = 0; i < typeCnt; ++i) {
                char x1 = types.get(i).charAt(0);
                char x2 = types.get(i).charAt(1);
                for (int j = 0; j < typeCnt; ++j) {
                    char y1 = types.get(j).charAt(0);
                    char y2 = types.get(j).charAt(1);
                    if (x1 != y1 && x2 != y2) {
                        related[i][j] = 1;
                    }
                }
            }
        } else if (m == 3) {
            for (int i = 0; i < typeCnt; ++i) {
                char x1 = types.get(i).charAt(0);
                char x2 = types.get(i).charAt(1);
                char x3 = types.get(i).charAt(2);
                for (int j = 0; j < typeCnt; ++j) {
                    char y1 = types.get(j).charAt(0);
                    char y2 = types.get(j).charAt(1);
                    char y3 = types.get(j).charAt(2);
                    if (x1 != y1 && x2 != y2 && x3 != y3) {
                        related[i][j] = 1;
                    }
                }
            }
        } else if (m == 4) {
            for (int i = 0; i < typeCnt; ++i) {
                char x1 = types.get(i).charAt(0);
                char x2 = types.get(i).charAt(1);
                char x3 = types.get(i).charAt(2);
                char x4 = types.get(i).charAt(3);
                for (int j = 0; j < typeCnt; ++j) {
                    char y1 = types.get(j).charAt(0);
                    char y2 = types.get(j).charAt(1);
                    char y3 = types.get(j).charAt(2);
                    char y4 = types.get(j).charAt(3);
                    if (x1 != y1 && x2 != y2 && x3 != y3 && x4 != y4) {
                        related[i][j] = 1;
                    }
                }
            }
        } else if (m == 5) {
            for (int i = 0; i < typeCnt; ++i) {
                char x1 = types.get(i).charAt(0);
                char x2 = types.get(i).charAt(1);
                char x3 = types.get(i).charAt(2);
                char x4 = types.get(i).charAt(3);
                char x5 = types.get(i).charAt(4);
                for (int j = 0; j < typeCnt; ++j) {
                    char y1 = types.get(j).charAt(0);
                    char y2 = types.get(j).charAt(1);
                    char y3 = types.get(j).charAt(2);
                    char y4 = types.get(j).charAt(3);
                    char y5 = types.get(j).charAt(4);
                    if (x1 != y1 && x2 != y2 && x3 != y3 && x4 != y4 && x5 != y5) {
                        related[i][j] = 1;
                    }
                }
            }
        }

        // 递推数组
        int[][] f = new int[n + 1][typeCnt];
        // 边界情况，第一行可以使用任何 type
        for (int i = 0; i < typeCnt; ++i) {
            f[1][i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < typeCnt; ++j) {
                for (int k = 0; k < typeCnt; ++k) {
                    // f[i][j] 等于所有 f[i - 1][k] 的和
                    // 其中 k 和 j 可以作为相邻的行
                    if (related[k][j] != 0) {
                        f[i][j] += f[i - 1][k];
                        f[i][j] %= MOD;
                    }
                }
            }
        }
        // 最终所有的 f[n][...] 之和即为答案
        int ans = 0;
        for (int i = 0; i < typeCnt; ++i) {
            ans += f[n][i];
            ans %= MOD;
        }
        return ans;
    }

}

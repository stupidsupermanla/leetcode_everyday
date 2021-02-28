package mainTime;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20210228 {

    public static void main(String[] args) {
        //[1,5,5,2,1,1,1,1,4,4,4,1,5,2,2,4,6,5,1,5,3,5,6,2,3,1,5,4,4,1,2,4,1,1,6,3,6,4,4,4,3,5,5,5,2,6,4,2,5,4,2,6,3,4,6,1,5,3,2,3,5,2,1,3,2,4,4,4,5,3,5,5,4,1,1,6,5,6,3,5,3,6,5,6,5,4,4,4,5,6,6,6,4,2,4,6,1,2,1,5,3,4,5,5,6,6,1,4,3,1,5,3,4,1,2,1,4,4,5,6,5,3,1,5,1,3,3,6,5,3,5,6,2,6,3,1,2,3,3,1,1,4,3,2,6,6,2,1,2,4,3,5,5,4,3,1,1,5,2,5,1,4,5,6,4,5,2,1,2,5,3,2,6,3,4,3,4,5,4,6,3,4,4,3,3,4,2,2,6,2,6,3,1,1,5,3,1,1,4,2,5,5,5,4,3,6,5,5,5,1,1,3,6,2,3,6,3,4,2,5,4,4,3,5,6,4,3,5,1,1,3,3,1,1,6,4,6,2,1,4,3,5,5]
        //[1,2,5,4,3,3,5,1,1,6,2,5,4,4,5,6,6,4,2,5,6,2,3,4,5,2,4,4,3,6,6,5,4,1,2,1,2,3,3,2,6,1,1,1,1,3,5,6,2,1,1,1,4,6,5]
//        Main20210228 main20210228 = new Main20210228();
//        System.out.println(main20210228.closestCost(new int[]{8, 10}, new int[]{1}, 4));
//        System.out.println(minOperations(new int[]{1, 5, 5, 2, 1, 1, 1, 1, 4, 4, 4, 1, 5, 2, 2, 4, 6, 5, 1, 5, 3, 5, 6, 2, 3, 1, 5, 4, 4, 1, 2, 4, 1, 1, 6, 3, 6, 4, 4, 4, 3, 5, 5, 5, 2, 6, 4, 2, 5, 4, 2, 6, 3, 4, 6, 1, 5, 3, 2, 3, 5, 2, 1, 3, 2, 4, 4, 4, 5, 3, 5, 5, 4, 1, 1, 6, 5, 6, 3, 5, 3, 6, 5, 6, 5, 4, 4, 4, 5, 6, 6, 6, 4, 2, 4, 6, 1, 2, 1, 5, 3, 4, 5, 5, 6, 6, 1, 4, 3, 1, 5, 3, 4, 1, 2, 1, 4, 4, 5, 6, 5, 3, 1, 5, 1, 3, 3, 6, 5, 3, 5, 6, 2, 6, 3, 1, 2, 3, 3, 1, 1, 4, 3, 2, 6, 6, 2, 1, 2, 4, 3, 5, 5, 4, 3, 1, 1, 5, 2, 5, 1, 4, 5, 6, 4, 5, 2, 1, 2, 5, 3, 2, 6, 3, 4, 3, 4, 5, 4, 6, 3, 4, 4, 3, 3, 4, 2, 2, 6, 2, 6, 3, 1, 1, 5, 3, 1, 1, 4, 2, 5, 5, 5, 4, 3, 6, 5, 5, 5, 1, 1, 3, 6, 2, 3, 6, 3, 4, 2, 5, 4, 4, 3, 5, 6, 4, 3, 5, 1, 1, 3, 3, 1, 1, 6, 4, 6, 2, 1, 4, 3, 5, 5},
//                new int[]{1, 2, 5, 4, 3, 3, 5, 1, 1, 6, 2, 5, 4, 4, 5, 6, 6, 4, 2, 5, 6, 2, 3, 4, 5, 2, 4, 4, 3, 6, 6, 5, 4, 1, 2, 1, 2, 3, 3, 2, 6, 1, 1, 1, 1, 3, 5, 6, 2, 1, 1, 1, 4, 6, 5}));
        System.out.println(minOperations(new int[]{6,6},new int[]{1}));
    }


    public static int minOperations(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (Math.min(len1, len2) * 6 < Math.max(len1, len2)) {
            return -1;
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i : nums1) {
            sum1 += i;
        }
        for (int i : nums2) {
            sum2 += i;
        }
        if (sum1 == sum2) {
            return 0;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int minSum = Math.min(sum1, sum2);
        int maxSum = Math.max(sum1, sum2);
        int[] minNums = sum1 > sum2 ? nums2 : nums1;
        int[] maxNums = sum1 > sum2 ? nums1 : nums2;
        int result = 0;
        int maxIndex = maxNums.length-1;
        int minIndex = 0;
        int maxFlag = 6;
        int minFlag = 1;
        while (minSum < maxSum) {
            if (minIndex < minNums.length) {
                if (minNums[minIndex] == minFlag) {
                    if (6 - minNums[minIndex] > 0) {
                        minSum += 6 - minNums[minIndex];
                        result++;
                    }
                    minIndex++;
                }
            }
            if (minSum < maxSum) {
                if (maxIndex >= 0) {
                    if (maxNums[maxIndex] == maxFlag) {
                        if (maxNums[maxIndex] - 1 > 0) {
                            maxSum -= maxNums[maxIndex] - 1;
                            result++;
                        }
                        maxIndex--;
                    }
                }
            }
            if (maxIndex<0 &&minIndex < minNums.length&& minNums[minIndex] != minFlag){
                minFlag++;
            }
            if (minIndex >= minNums.length && maxIndex>=0&&maxNums[maxIndex] != maxFlag){
                maxFlag--;
            }
            if (maxIndex>=0&&minIndex < minNums.length&& minNums[minIndex] != minFlag && maxNums[maxIndex] != maxFlag) {
                minFlag++;
                maxFlag--;
            }
        }


        return result;
    }

    int target;
    int temp;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int len = baseCosts.length;
        this.target = target;
        int result = 0;
        for (int i = 0; i < len; i++) {
            int base = baseCosts[i];
            if (base == target) {
                return target;
            }
            if (base > target) {
                if (result == 0) {
                    result = base;
                    continue;
                }
                if (base - target < Math.abs(result - target)) {
                    result = base;
                    continue;
                }
                continue;
            }
            dfs(base, toppingCosts, 0);
            if (temp == target) {
                return target;
            } else {
                if (result == 0) {
                    result = temp;
                    continue;
                }
                if (Math.abs(temp - target) == Math.abs(result - target)) {
                    result = Math.min(temp, result);
                    continue;
                }
                if (Math.abs(temp - target) < Math.abs(result - target)) {
                    result = temp;
                    continue;
                }
            }
            temp = 0;
        }
        return result;
    }

    private void dfs(int base, int[] toppingCosts, int index) {
        if (temp == target) {
            return;
        }
        if (base > target) {
            if (base - target < Math.abs(temp - target)) {
                temp = base;
            }
            return;
        }
        if (base == target) {
            temp = base;
            return;
        }
        if (base < target && target - base < Math.abs(temp - target)) {
            temp = base;
        }
        if (index >= toppingCosts.length) {
            return;
        }
        dfs(base, toppingCosts, index + 1);
        dfs(base + toppingCosts[index], toppingCosts, index + 1);
        dfs(base + 2 * toppingCosts[index], toppingCosts, index + 1);
    }

//

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> ruleMap = new HashMap<>();
        ruleMap.put("type", 0);
        ruleMap.put("color", 1);
        ruleMap.put("name", 2);
        int result = 0;
        int rule = ruleMap.get(ruleKey);
        for (List<String> item : items) {
            if (item.get(rule).equals(ruleValue)) {
                result++;
            }
        }
        return result;
    }
}

package mainTime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class Main20210110 {

    public static void main(String[] args) {
//        int[] decode = decode(new int[]{6, 2, 7, 3}, 4);
//        for (int i : decode) {
//            System.out.println(i);
//        }
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        ListNode listNode = swapNodes(l1, 1);
//        System.out.println();

//        {41,37,51,100,25,33,90,49,65,87,11,18,15,18}
//{41,92,69,75,29,13,53,21,17,81,33,19,33,32}
//{{0,11},{5,9},{6,9},{5,7},{8,13},{4,8},{12,7},{8,2},{13,5},{0,7},{6,4},{8,9},{4,12},{6,1},{10,0},{10,2},{7,3},{11,10},{5,2},{11,1},{3,0},{8,5},{12,6},{2,1},{11,2},{4,9},{2,9},{10,6},{12,10},{4,13},{13,2},{11,9},{3,6},{0,4},{1,10},{5,11},{12,1},{10,4},{6,2},{10,7},{3,13},{4,5},{13,10},{4,7},{0,12},{9,10},{9,3},{0,5},{1,9},{5,10},{8,0},{12,11},{11,4},{7,9},{7,2},{13,9},{12,3},{8,6},{7,6},{8,12},{4,3},{7,13},{0,13},{2,0},{3,8},{8,1},{13,6},{1,4},{0,9},{2,3},{8,7},{4,2},{9,12}}


//        int[] source=new int[]{1,2,3,4};
        int[] source = new int[]{41, 37, 51, 100, 25, 33, 90, 49, 65, 87, 11, 18, 15, 18};
        int[] target = new int[]{41, 92, 69, 75, 29, 13, 53, 21, 17, 81, 33, 19, 33, 32};
//        int[] target=new int[]{1,3,2,4};
//        int[] target=new int[]{2,1,4,5};
//        int[][] allowedSwaps=new int[][]{{0,1},{2,3}};
        int[][] allowedSwaps = new int[][]{{0, 11}, {5, 9}, {6, 9}, {5, 7}, {8, 13}, {4, 8}, {12, 7}, {8, 2}, {13, 5}, {0, 7}, {6, 4}, {8, 9}, {4, 12}, {6, 1}, {10, 0}, {10, 2}, {7, 3}, {11, 10}, {5, 2}, {11, 1}, {3, 0}, {8, 5}, {12, 6}, {2, 1}, {11, 2}, {4, 9}, {2, 9}, {10, 6}, {12, 10}, {4, 13}, {13, 2}, {11, 9}, {3, 6}, {0, 4}, {1, 10}, {5, 11}, {12, 1}, {10, 4}, {6, 2}, {10, 7}, {3, 13}, {4, 5}, {13, 10}, {4, 7}, {0, 12}, {9, 10}, {9, 3}, {0, 5}, {1, 9}, {5, 10}, {8, 0}, {12, 11}, {11, 4}, {7, 9}, {7, 2}, {13, 9}, {12, 3}, {8, 6}, {7, 6}, {8, 12}, {4, 3}, {7, 13}, {0, 13}, {2, 0}, {3, 8}, {8, 1}, {13, 6}, {1, 4}, {0, 9}, {2, 3}, {8, 7}, {4, 2}, {9, 12}};
        System.out.println(minimumHammingDistance(source, target, allowedSwaps));
    }

    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        List<Set<Integer>> swapList = new ArrayList<>();
        for (int[] allowedSwap : allowedSwaps) {
            int s1 = allowedSwap[0];
            int s2 = allowedSwap[1];
            boolean flag = true;
            List<Integer> addP = new ArrayList<>();
            for (int i = 0; i < swapList.size(); i++) {
                Set<Integer> set = swapList.get(i);
                if (set.contains(s1) || set.contains(s2)) {
                    addP.add(i);
                    set.add(s1);
                    set.add(s2);
                    flag = false;
                }
            }
            if (addP.size() == 2) {
                Set<Integer> set1 = swapList.get(addP.get(0));
                Set<Integer> set2 = swapList.get(addP.get(1));
                set1.addAll(set2);
                swapList.remove(addP.get(1).intValue());
            }
            if (flag) {
                Set<Integer> set = new HashSet<>();
                set.add(s1);
                set.add(s2);
                swapList.add(set);
            }
        }

        int result = 0;
        for (Set<Integer> set : swapList) {
            List<Integer> l1=new ArrayList<>();
            List<Integer> l2=new ArrayList<>();
//            int[] d1 = new int[set.size()];
//            int[] d2 = new int[set.size()];
//            int index = 0;
            for (Integer integer : set) {
                l1.add(source[integer]);
                l2.add(target[integer]);
//                d1[ndex] = source[integer];
//                d2[index] = target[integer];
                target[integer] = 0;
//                index++;
            }

            for (Integer integer : l1) {
                if (!l2.contains(integer)) {
                    result ++;
                }
            }
        }
        for (
                int i = 0;
                i < target.length; i++) {
            if (target[i] != 0 && target[i] != source[i]) {
                result++;
            }
        }
        return result;
    }

//    public int minimumTimeRequired(int[] jobs, int k) {
//
//    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode fre = new ListNode(-1);
        fre.next = head;
        ListNode lastK = head;
        ListNode firstK = head;
        ListNode temp = head;
        ListNode preFirstK = fre;
        ListNode preLastK = fre;
        for (int i = 1; i < k; i++) {
            preFirstK = firstK;
            firstK = firstK.next;
            temp = temp.next;
        }
        while (temp.next != null) {
            preLastK = lastK;
            lastK = lastK.next;
            temp = temp.next;
        }
        preFirstK.next = lastK;
        preLastK.next = firstK;
        temp = firstK.next;
        firstK.next = lastK.next;
        lastK.next = temp;
        return fre.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            result[i + 1] = encoded[i] ^ result[i];
        }
        return result;
    }

}

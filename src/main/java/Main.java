import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        //System.out.println("Hello World!");

//
//        Node node2 = new Node(3,null);
//        Node node1 = new Node(4,node2);
//        Node head1 = new Node(2,node1);
//        Node node4 = new Node(4,null);
//        Node node3 = new Node(6,node4);
//        Node head2 = new Node(5,node3);
//        Node head = addNode(head1,head2);


        List<List<Integer>> lists = allPL(new int[]{1, 2, 3});
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + ",");
            }
            System.out.println();
        }

    }


    public static List<List<Integer>> allPL(int[] nums) {
        for (int num : nums) {
            temp.add(num);
        }
        dfsAllPL(0);
        return result;
    }

    private static void dfsAllPL(int first) {
        if (temp.size() == first) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = first; i < temp.size(); i++) {
            Collections.swap(temp,first,i);
            dfsAllPL(first+1);
            Collections.swap(temp,first,i);
        }
    }


    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();

    public static List<List<Integer>> allZH(int[] nums) {
        dfsAllZH(nums, 0);
        return result;
    }

    private static void dfsAllZH(int[] nums, int index) {
        if (index >= nums.length) {
            return;
        }
        temp.add(nums[index]);
        if (temp.size() != 0) {
            result.add(new ArrayList<>(temp));
        }
        dfsAllZH(nums, ++index);
        temp.remove(temp.size() - 1);
        dfsAllZH(nums, index);
    }


    public static Node addNode(Node head1, Node head2) {
        Node head = null;
        Node temp = null;
        boolean isFirst = true;
        int plus = 0;
        while (head1 != null || head2 != null) {
            int v1 = 0;
            int v2 = 0;
            if (head1 != null) {
                v1 = head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                v2 = head2.val;
                head2 = head2.next;
            }
            int cur = v1 + v2 + plus;
            if (cur >= 10) {
                plus = 1;
                cur -= 10;
            } else {
                plus = 0;
            }
            if (isFirst) {
                head = new Node(cur, null);
                temp = head;
            } else {
                Node node = new Node(cur, null);
                temp.next = node;
                temp = node;
            }
        }
        return head;
    }


    public static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }


    // 接雨水
    public static int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();

        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }


    // 是否回文数
    public static boolean isHuiWen(int x) {
        y = x;
        return dfs(x);
    }

    static int y;

    private static boolean dfs(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        if (dfs(x / 10) && x % 10 == y % 10) {
            y /= 10;
            return true;
        } else {
            return false;
        }
    }
}

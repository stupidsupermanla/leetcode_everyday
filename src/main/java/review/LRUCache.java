package review;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity;
    Map<Integer,ListNode> valueMap;
    ListNode head = new ListNode();
    ListNode end = new ListNode();


    class ListNode{
        int key;
        int value;
        ListNode pre;
        ListNode next;
    }


    public LRUCache(int capacity) {
        this.valueMap = new HashMap<>();
        this.capacity = capacity;
        this.head.next = end;
        this.end.pre = head;
    }

    public int get(int key) {
        if (!valueMap.containsKey(key)){
            return -1;
        }
        ListNode listNode = valueMap.get(key);
        // 删除链条
        deleteNode(listNode);
        // 将node移到头部
        toHead(listNode);
        return listNode.value;
    }

    private void toHead(ListNode listNode) {
        listNode.next = head.next;
        listNode.pre = head;
        head.next.pre = listNode;
        head.next = listNode;
    }

    private static void deleteNode(ListNode listNode) {
        listNode.pre.next = listNode.next;
        listNode.next.pre = listNode.pre;
    }

    public void put(int key, int value) {
        if (valueMap.containsKey(key)){
            // 替换value，将node移到最前
            ListNode listNode = valueMap.get(key);
            listNode.value = value;
            // 删除链条
            deleteNode(listNode);
            // 将node移到头部
            toHead(listNode);
        }else {
            if (valueMap.size()==capacity){
                ListNode last = end.pre;
                deleteNode(last);
                valueMap.remove(last.key);
            }
            ListNode listNode = new ListNode();
            listNode.key = key;
            listNode.value = value;
            toHead(listNode);
            valueMap.put(key,listNode);
        }
    }
}

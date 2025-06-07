package review;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    Map<Integer,ListNode> valueMap;
    Map<Integer,ListNodeList> freqMap;
    int capacity;
    int minFreq;
    class ListNode{
        int key;
        int value;
        int freq;
        ListNode pre;
        ListNode next;
    }

    class ListNodeList {
        int size;
        ListNode head;
        ListNode tail;

        public ListNodeList(){
            this.size = 0;
            head = new ListNode();
            tail = new ListNode();
            head.next=tail;
            tail.pre = head;
        }

        void addToHead(ListNode node) {
            head.next.pre=node;
            node.next = head.next;
            node.pre = head;
            head.next = node;
            this.size++;
        }

        void deleteNode(ListNode listNode) {
            listNode.pre.next = listNode.next;
            listNode.next.pre = listNode.pre;
            this.size --;
        }
    }
    
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        valueMap = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 0;
    }

    public int get(int key) {
        if (!valueMap.containsKey(key)){
            return -1;
        }
        ListNode listNode = valueMap.get(key);
        int freq = listNode.freq;
        ListNodeList listNodeList = freqMap.get(freq);
        if (listNodeList.size==1) {
            freqMap.remove(freq);
            if (minFreq==freq){
                minFreq++;
            }
        }else {
            listNodeList.deleteNode(listNode);
        }
        freq++;
        listNode.freq=freq;
        ListNodeList newFreqListNodeList = freqMap.getOrDefault(freq, new ListNodeList());
        newFreqListNodeList.addToHead(listNode);
        freqMap.put(freq,newFreqListNodeList);
        return listNode.value;
    }



    public void put(int key, int value) {
        if (!valueMap.containsKey(key)){
            // 处理越界情况
            if (capacity==valueMap.size()){
                // 取出minfreq的list，remove最后的node
                ListNodeList listNodeList = freqMap.get(minFreq);
                ListNode pre = listNodeList.tail.pre;
                if (listNodeList.size==1){
                    freqMap.remove(minFreq);
                }else {
                    listNodeList.deleteNode(pre);
                }
                valueMap.remove(pre.key);
            }
            minFreq = 1;
            ListNode listNode = new ListNode();
            listNode.key = key;
            listNode.value = value;
            listNode.freq=1;
            valueMap.put(key,listNode);
            ListNodeList oneListNodeList = freqMap.getOrDefault(minFreq,new ListNodeList());
            oneListNodeList.addToHead(listNode);
            freqMap.put(minFreq,oneListNodeList);
        }else {
            get(key);
            ListNode listNode = valueMap.get(key);
            listNode.value = value;
            valueMap.put(key,listNode);
        }
    }
}

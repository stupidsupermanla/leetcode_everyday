package mainTime;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class FrontMiddleBackQueue {

    List<Integer> queue;

    public FrontMiddleBackQueue() {
        queue = new LinkedList<>();
    }

    public void pushFront(int val) {
        queue.add(0, val);
    }

    public void pushMiddle(int val) {
        int mid = queue.size() / 2;
        queue.add(mid, val);
    }

    public void pushBack(int val) {
        queue.add(val);
    }

    public int popFront() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer integer = queue.get(0);
        queue.remove(0);
        return integer;

    }

    public int popMiddle() {
        if (queue.isEmpty()) {
            return -1;
        }
        int mid = (queue.size() - 1) / 2;
        Integer integer = queue.get(mid);
        queue.remove(mid);
        return integer;
    }

    public int popBack() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer integer = queue.get(queue.size() - 1);
        queue.remove(queue.size() - 1);
        return integer;
    }


}

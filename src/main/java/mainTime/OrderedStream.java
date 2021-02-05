package mainTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author hudi
 * @Date 2018/12/22 16:58
 * @Version 1.0
 **/
public class OrderedStream {

    int ptr;
    String[] values;
    int size;

    public OrderedStream(int n) {
        values = new String[n];
        Arrays.fill(values,null);
        ptr = 0;
        size = n;
    }

    public List<String> insert(int id, String value) {
        values[id - 1] = value;
        List<String> result = new ArrayList<>();
        while (ptr < size && values[ptr] != null) {
            result.add(values[ptr]);
            ptr++;
        }
        return result;
    }
}

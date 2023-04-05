package medium;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {


    class LRUNode{
        int key;
        int value;

        LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private LinkedList<LRUNode> queue;
    private HashMap<Integer, LRUNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }else {

            queue.remove(map.get(key));
            queue.addFirst(map.get(key));

            return map.get(key).value;
        }
    }

    public void put(int key, int value) {
        LRUNode newNode = new LRUNode(key, value);
        if (map.get(key) == null) {
            // 没有数据

            if (queue.size() >= this.capacity) {
                // 数据量达到上限
                LRUNode deleteNode = queue.pollLast();
                map.remove(deleteNode.key);
            }
            queue.addFirst(newNode);
            map.put(key, newNode);
        }else {
            queue.remove(map.get(key));

            map.put(key, newNode);
            queue.addFirst(newNode);
        }
    }
}

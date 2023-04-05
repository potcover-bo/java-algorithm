package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((key1, key2) -> (key1[1] - key2[1]));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (heap.size() < k) {
                heap.add(new int[]{entry.getKey(), entry.getValue()});
            } else if (heap.peek()[1] < entry.getValue()) {
                heap.poll();
                heap.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[0];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};

        int[] res = topKFrequent(nums, 2);
        for (int r : res) {
            System.out.print(r + " ");
        }
    }
}

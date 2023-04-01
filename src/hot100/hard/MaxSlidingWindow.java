package hot100.hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 */
public class MaxSlidingWindow {

    /**
     *  维护从大到小的队列 队列存放的是索引
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length < 2) {
            return nums;
        }
        
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // 维护队列
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            // 当前索引加入到队列中
            queue.addLast(i);

            //判断队首索引是否合法
            if (queue.peekFirst() <= i - k){
                queue.pollFirst();
            }

            if (i + 1 >= k){
                res[i - k + 1] = nums[queue.peekFirst()];
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}

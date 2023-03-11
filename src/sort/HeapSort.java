package sort;

import utils.ArrayUtils;

/**
 * 堆中某个节点的总是大于子节点的值
 * 左孩子等于： 2 * i + 1
 * 右孩子等于： 2 * i + 2
 * 父节点等于： i - 1 / 2
 */
public class HeapSort {

    public static <E extends Comparable<E>> void sort(E[] nums) {

        // 构造最大堆
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            ArrayUtils.swap(nums, 0, i);
            heapify(nums, 0, i);
        }

    }

    private static <E extends Comparable<E>> void heapify(E[] nums, int i, int k) {
        while (i < k && 2 * i + 1 < k) {
            int maxIndex = 2 * i + 1;
            if (2 * i + 2 < k && nums[2 * i + 1].compareTo(nums[2 * i + 2]) < 0) {
                // 左右孩子中的最大值
                maxIndex++;
            }
            if (nums[i].compareTo(nums[maxIndex]) < 0) {
                ArrayUtils.swap(nums, i, maxIndex);
                i = maxIndex;
            }else {
                break;

            }
        }
    }

    /**
     * 将一个元素插入堆中去
     * @param nums
     * @param index
     * @param <E>
     */
    private static <E extends Comparable<E>> void heapInsert(E[] nums, int index) {
        while (index > 0) {
            if (nums[index].compareTo(nums[(index - 1) / 2]) > 0) {
                ArrayUtils.swap(nums, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }else {
                break;
            }
        }
    }

}

package sort;

import utils.ArrayUtils;

/**
 * 选择排序
 *
 * 先把最小的拿出来
 * 剩下的里面最小的拿出来。。。
 */
public class SelectionSort {

    public static <E extends Comparable<E>> void sort(E[] arr){
        // arr[0...i) 有序 arr[i...n)无序
        for (int i = 0; i < arr.length -1; i++) {
            // arr[i...n）中最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0) {
                    minIndex = j;
                }
            }
            ArrayUtils.swap(arr, i, minIndex);
        }
    }
}

package sort;


import utils.ArrayUtils;

import java.util.Random;

public class QuickSort {
    private static Random random = new Random();
    private QuickSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p -1);
        sort(arr, p + 1, r);
    }

    /**
     * [l, r]分区
     * [l, p] 小于arr[p] [p+1, r]大于arr[p]
     * @param arr
     * @param l
     * @param r
     * @return
     * @param <E>
     */
    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {

        // 生产一个[0, r-l]随机值
        int p = random.nextInt(r - l + 1) + l;
        ArrayUtils.swap(arr, l, p);

        // arr[l + 1, j] < v
        // arr[j + 1, i] >= v
        int j = l; // 锚点
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0){
                j++;
                ArrayUtils.swap(arr, i, j);
            }
        }
        ArrayUtils.swap(arr, l, j);
        return j;
    }
}

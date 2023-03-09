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


    //双路快排
    public static <E extends Comparable<E>> void sort2ways(E[] arr) {

        sort2ways(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort2ways(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition2(arr, l, r);
        sort2ways(arr, l, p -1);
        sort2ways(arr, p + 1, r);
    }

    /**
     * 双路快排
     * @param arr
     * @param l
     * @param r
     * @return
     * @param <E>
     */
    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r) {

        // 生产一个[0, r-l]随机值
        int p = random.nextInt(r - l + 1) + l;
        ArrayUtils.swap(arr, l, p);

        // arr[l+1, i-1] <=v
        // arr[j +1, r] >=v
        int i = l + 1;
        int j = r;

        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0){
                i++;
            }

            while (i <= j && arr[j].compareTo(arr[l]) > 0){
                j--;
            }
            if (i >= j) {
                break;
            }

            ArrayUtils.swap(arr, i, j);
            i++;
            j--;
        }
        ArrayUtils.swap(arr, l, j);
        return j;
    }

    /**
     * 三路快排
     * @param arr
     * @param l
     * @param r
     * @return
     * @param <E>
     */
    private static <E extends Comparable<E>> int[] partition3(E[] arr, int l, int r) {

        // 生产一个[0, r-l]随机值
        int p = random.nextInt(r - l + 1) + l;
        ArrayUtils.swap(arr, l, p);

        // arr[l+1, lt] <v
        // arr[lt + 1, i -1] == v
        // arr[gt, r] >v
        int lt = l; // 小于v部分的最后一个元素
        int i = l + 1; // 当前处理的元素
        int gt = r + 1; //大于v部分的第一个元素

        while (i < gt) {
            // arr[i] < v lt的边界扩展 当前元素前进一个
            if (arr[i].compareTo(arr[l]) <0){
                lt++;
                ArrayUtils.swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                // arr[i] > v gt边界扩展 此时i不变
                gt--;
                ArrayUtils.swap(arr, i, gt);
            }else {
                //arr[i] == v
                i++;
            }
        }

        // 此时lt是小于v的下一个元素
        ArrayUtils.swap(arr, l, lt);

        return new int[]{lt -1, gt};
    }
}

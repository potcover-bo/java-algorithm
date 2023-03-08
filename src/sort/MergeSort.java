package sort;

import java.util.Arrays;

public class MergeSort {

    private MergeSort(){}

    public static <E extends Comparable<E>>void sort(E[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 对 [l, r]闭区间进行排序
     * @param arr
     * @param l
     * @param r
     */
    private static <E extends Comparable<E>> void mergeSort(E[] arr, int l, int r) {
        //递归终止条件
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        // 左半边排序
        mergeSort(arr, l, mid);
        // 右半边排序
        mergeSort(arr, mid + 1, r);

        //将arr[l, mid] 和arr[mid + 1, r] 进行合并
        merge(arr, l, mid, r);
    }

    /**
     * 将arr[l, mid] 和arr[mid + 1, r] 进行合并
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <=r; k++){
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            }else {
                arr[k] = temp[j - l];
                j++;
            }
        }

    }
}

package sort;

import java.util.Arrays;

public class MergeSort {

    private MergeSort(){}

    public static <E extends Comparable<E>>void sort(E[] arr) {
        E[] temp = Arrays.copyOfRange(arr, 0, arr.length);
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    /**
     * 对 [l, r]闭区间进行排序
     * @param arr
     * @param l
     * @param r
     */
    private static <E extends Comparable<E>> void mergeSort(E[] arr, int l, int r, E[] temp) {
        //递归终止条件
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        // 左半边排序
        mergeSort(arr, l, mid, temp);
        // 右半边排序
        mergeSort(arr, mid + 1, r, temp);

        //将arr[l, mid] 和arr[mid + 1, r] 进行合并
        // merge optimize
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, temp);
        }

    }

    /**
     * 将arr[l, mid] 和arr[mid + 1, r] 进行合并
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <=r; k++){
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            }else {
                arr[k] = temp[j];
                j++;
            }
        }
    }
}

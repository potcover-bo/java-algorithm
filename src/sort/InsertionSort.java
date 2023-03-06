package sort;

import utils.ArrayUtils;

/**
 * arr[0, i) 已经排好序 arr[i...)未排序
 * 把arr[i] 放到合适位置
 */
public class InsertionSort {

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >0 ; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0){
                    ArrayUtils.swap(arr, j, j - 1);
                }else {
                    break;
                }
            }
        }
    }
}

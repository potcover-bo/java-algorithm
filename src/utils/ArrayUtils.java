package utils;

import sort.*;

import java.util.Random;

public class ArrayUtils {
    /**
     * 交换数组中两个元素
     * @param arr
     * @param first
     * @param second
     */
    public static <E> void swap(E[] arr, int first, int second) {
        E temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static <E> void printArray(E[] arr) {
        for (E num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * 生成长度为n的随机数组
     * @param n
     * @param bound
     * @return
     */
    public static Integer[] generateRandomArray(int n, int bound){
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);

        }
        return arr;
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {
        long startTime = System.nanoTime();
        if (sortName.equals("SelectionSort")) {
            SelectionSort.sort(arr);
        }else if (sortName.equals("InsertionSort")){
            InsertionSort.sort(arr);
        }else if (sortName.equals("MergeSort")){
            MergeSort.sort(arr);
        } else if (sortName.equals("QuickSort")) {
            QuickSort.sort(arr);
        }else if (sortName.equals("HeapSort")) {
            HeapSort.sort(arr);
        }

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000.0;
        boolean sorted = ArrayUtils.isSorted(arr);
        if (!sorted) {
            throw new RuntimeException(sortName + "failed");
        }
        System.out.println(sortName + ":  length: "+arr.length +", cost: " +time + "ms");
    }
}

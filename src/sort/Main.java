package sort;

import utils.ArrayUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Integer[] arr = {5, 65, 324, 634, 23423, 5, 7, 1};
//        SelectionSort.sort(arr);
//        ArrayUtils.printArray(arr);
//        System.out.println();
//
//        Student[] students = {new Student("Alice", 98),
//                new Student("Bobo", 100),
//                new Student("CC", 66)};
//        SelectionSort.sort(students);
//        ArrayUtils.printArray(students);
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] randomArray = ArrayUtils.generateRandomArray(n, n);
            Integer[] insert = Arrays.copyOfRange(randomArray, 0, randomArray.length);
            Integer[] select = Arrays.copyOfRange(randomArray, 0, randomArray.length);

            ArrayUtils.sortTest("MergeSort", randomArray);
            ArrayUtils.sortTest("InsertionSort", insert);
            ArrayUtils.sortTest("SelectionSort", select);
        }

    }
}

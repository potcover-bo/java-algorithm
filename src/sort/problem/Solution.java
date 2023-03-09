package sort.problem;

import java.util.Arrays;

public class Solution {
    public int reversePairs1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    res++;
                }
            }
        }

        return res;
    }

    public int reversePairs(int[] nums) {
        int[] temp = Arrays.copyOfRange(nums, 0, nums.length);
        return mergeSort(nums, 0, nums.length - 1, temp);
    }

    private int mergeSort(int[] nums, int l, int r, int[] temp) {
        if (l >= r){
            return 0;
        }
        int res = 0;
        int mid = l + (r - l) / 2;
        // 左边子数组的逆序对
        res += mergeSort(nums, l, mid, temp);
        // 右边子数组的逆序对
        res += mergeSort(nums, mid + 1, r, temp);
        if (nums[mid] > nums[mid + 1]){
            // 左边子数组和右边子数组能组成的逆序对
            res += merge(nums, l , mid, r, temp);
        }
        return res;

    }

    private int merge(int[] nums, int l, int mid, int r, int[] temp) {
        int res = 0;
        System.arraycopy(nums, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            // 左边已经没有值
            if (i > mid) {
                nums[k] = temp[j];
                j++;
            } else if (j > r) {
                // 右边已经没有值
                nums[k] = temp[i];
                i++;
            } else if (temp[i] > temp[j]) {
                nums[k] = temp[j];
                j++;
                res = res + mid - i + 1;
            }else {
                nums[k] = temp[i];
                i++;
            }
        }

        return res;
    }


    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *
     * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int lt = 0, i = 0, gt = nums.length - 1;
        while (i <= gt) {
            if (nums[i] == 0){
                swap(nums, i, lt);
                lt++;
                i++;
            }else if (nums[i] == 2){
                swap(nums, i, gt);
                gt--;
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 1};
        sortColors(arr);
    }
}

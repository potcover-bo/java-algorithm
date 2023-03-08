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

}

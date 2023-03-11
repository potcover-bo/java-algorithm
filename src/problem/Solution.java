package problem;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {};
        int[] res = searchRange(nums, 6);
        for (int num : res) {
            System.out.print(num + " ");
        }


    }

    /**------------------1-day------------------------------*/

    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int idx = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                idx = mid;
                break;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        if (idx == -1) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        l = idx;
        r = idx;
        while (l >= 0 && nums[l] == target) {
            l--;
        }
        res[0] = l + 1;
        while (r < nums.length && nums[r] == target) {
            r++;
        }
        res[1] = r - 1;

        return res;

    }


}

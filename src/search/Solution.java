package search;

public class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private  int search(int[] arr, int l, int r, int target) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (arr[mid] == target){
            return mid;
        }else if (arr[mid] > target){
            return search(arr, l, mid - 1, target);
        }else{
            return search(arr, mid + 1, r, target);
        }
    }
}

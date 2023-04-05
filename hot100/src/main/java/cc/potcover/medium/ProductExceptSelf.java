package cc.potcover.medium;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int cur = 1;
        int[] leftVal = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            leftVal[i] = left;

            left *= nums[i];
        }

        for (int i = nums.length - 1 ; i >= 0; i--) {
            cur = nums[i];
            nums[i] = right * leftVal[i];
            right *= cur;
        }

        return nums;
    }
}

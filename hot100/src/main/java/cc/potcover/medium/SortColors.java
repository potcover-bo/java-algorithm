package cc.potcover.medium;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 */
public class SortColors {

    /**
     * 刷油漆算法
     * @param nums
     */
    public static void sortColors2(int[] nums) {
        int n0 = 0, n1 = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            nums[i] = 2;
            if(num < 2){
                nums[n1++] = 1;
            }
            if(num < 1){
                nums[n0++] = 0;
            }
        }
    }


    public static void sortColors(int[] nums) {
        int left = -1;
        int cur = 0;
        int right = nums.length;

        while (cur < right) {
            if (nums[cur] == 1) {
                cur++;
            }else if (nums[cur] == 0){
                swap(nums, cur++, ++left);
            }else {
                swap(nums, cur, --right);
            }

        }
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors2(nums);
        for (int num : nums) {
            System.out.print(num + " ");

        }
    }
}

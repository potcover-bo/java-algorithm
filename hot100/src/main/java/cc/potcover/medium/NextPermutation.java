package cc.potcover.medium;

import java.util.Arrays;

/**
 * 31 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 */
public class NextPermutation {
    static String res = "";
    public static void nextPermutation(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        boolean[] used = new boolean[nums.length];
        String target = sb.toString();

        String pre = "";
        Arrays.sort(nums);
        backtrack(nums, new StringBuilder(), pre, target, used);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(target.charAt(i) + "");
        }
    }

    private static void backtrack(int[] nums, StringBuilder path, String pre, String target, boolean[] used) {
        if (nums.length == path.length()) {
            if (pre.equals(target)) {
                res = path.toString();
                return;
            }
            pre = path.toString();
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.append(nums[i]);
                used[i] = true;

                backtrack(nums, path, pre, target, used);

                path.deleteCharAt(path.length() - 1);
                used[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + "");
        }

    }
}

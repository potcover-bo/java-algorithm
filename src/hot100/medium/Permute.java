package hot100.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 46 全排列
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, res, new ArrayList<Integer>());

        return res;
    }

    private static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(nums[i])) {
                continue;
            }
            tmp.add(nums[i]);
            backtrack(nums, res, tmp);

            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        List<List<Integer>> res = permute(nums);

        System.out.println(res);


    }
}

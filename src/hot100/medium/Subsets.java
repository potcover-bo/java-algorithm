package hot100.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();


        backtrack(nums, res, 0, new ArrayList<>());

        return res;
    }

    private static void backtrack(int[] nums, List<List<Integer>> res, int start, ArrayList<Integer> path) {

        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {

            path.add(nums[i]);

            backtrack(nums, res, i + 1, path);

            path.remove(path.size() - 1);

        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> res = subsets(nums);

        System.out.println(res);

    }
}

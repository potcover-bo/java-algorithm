package hot100.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    public static void backtrack(int[] candidates, int begin, int target, List<Integer> path, List<List<Integer>> res) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            path.add(candidates[i]);

            backtrack(candidates, i, target - candidates[i], path, res);

            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};

        System.out.println(combinationSum(candidates, 7));

    }
}

package cc.potcover.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        backtrack(n, n, res, new StringBuilder());

        return res;
    }

    private void backtrack(int left, int right, List<String> res, StringBuilder track) {
        if (left < 0 || right < 0) {
            return;
        }
        if (right < left) {
            return;
        }

        if (left == 0 && right == 0) {
            res.add(track.toString());
        }

        track.append("(");
        backtrack(left - 1, right, res, track);
        track.deleteCharAt(track.length() - 1);


        track.append(")");
        backtrack(left, right - 1, res, track);
        track.deleteCharAt(track.length() - 1);
    }
}

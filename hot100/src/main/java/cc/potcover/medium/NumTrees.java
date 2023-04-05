package cc.potcover.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树
 * 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class NumTrees {
    static Map<Integer, Integer> map = new HashMap<>();
    public static int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            int left = numTrees(i - 1);
            int right = numTrees(n - i);

            cnt += left * right;
        }

        map.put(n, cnt);

        return cnt;
    }
}

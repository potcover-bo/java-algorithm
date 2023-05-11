package hot100.easy;


import hot100.TreeNode;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}

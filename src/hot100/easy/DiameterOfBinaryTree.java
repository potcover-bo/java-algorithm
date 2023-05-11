package hot100.easy;


import hot100.TreeNode;

public class DiameterOfBinaryTree {
    int maxVal;
    public int diameterOfBinaryTree(TreeNode root) {
        this.maxVal = 0;
        dfs(root);

        return maxVal - 1;

    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lDepth = dfs(root.left);
        int rDepth = dfs(root.right);

        maxVal = Math.max(maxVal, lDepth + rDepth + 1);


        return Math.max(lDepth, rDepth) + 1;

    }
}

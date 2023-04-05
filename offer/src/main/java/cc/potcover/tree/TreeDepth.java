package cc.potcover.tree;


import cc.potcover.TreeNode;

/**
 * JZ55 二叉树的深度
 */
public class TreeDepth {

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}

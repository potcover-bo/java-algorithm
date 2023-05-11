package cc.potcover.tree;

import offer.TreeNode;

/**
 * JZ27 二叉树的镜像
 */
public class Mirror {
    public TreeNode Mirror (TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        TreeNode leftNode = pRoot.left;
        TreeNode rightNode = pRoot.right;
        pRoot.left = Mirror(rightNode);
        pRoot.right = Mirror(leftNode);

        return pRoot;
    }
}

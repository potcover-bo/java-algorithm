package cc.potcover.medium;

import cc.potcover.TreeNode;

/**
 * 114. 二叉树展开为链表
 */
//TODO 展开链表
public class Flatten {
    public void flatten(TreeNode root) {

        while (root != null) {
            if (root.left == null) {
                root = root.right;
            }else {
                // 找左子树最右边节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                //最右边的节点指向root的right
                pre.right = root.right;

                // 左子树插入右子树当中
                root.right = root.left;
                root.left = null;

                //下一个节点
                root = root.right;
            }
        }

    }
}

package hot100.medium;

import cc.potcover.TreeNode;
import linked_list.problem.ListNode;

public class ConvertBST {

    static int pre = 0;

    public static TreeNode convertBST(TreeNode root) {
        return order(root);

    }

    private static TreeNode order(TreeNode cur) {
        if (cur != null) {
            cur.right = order(cur.right);
            pre += cur.val;
            cur.val = pre;
            cur.left = order(cur.left);

            return cur;
        }else {
            return null;
        }


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(1);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        root.left.right.right = new TreeNode(3);

        root.right.right.right = new TreeNode(8);

        convertBST(root);
    }
}

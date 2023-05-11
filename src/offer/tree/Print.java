package offer.tree;

import offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * JZ77 按之字形顺序打印二叉树
 */
public class Print {

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        boolean flag = true;
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (flag) {
                    TreeNode cur = queue.remove();
                    temp.add(cur.val);
                    if (cur.left != null) {
                        queue.add(cur.left);
                    }
                    if (cur.right != null) {
                        queue.add(cur.right);
                    }
                }else {
                    TreeNode cur = queue.removeLast();
                    temp.add(cur.val);
                    if (cur.right != null) {
                        queue.addFirst(cur.right);
                    }
                    if (cur.left != null) {
                        queue.addFirst(cur.left);
                    }
                }
            }

            res.add(temp);
            flag = !flag;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8, new TreeNode(6, new TreeNode(5), new TreeNode(7)), new TreeNode(10, new TreeNode(9), new TreeNode(11)));

        ArrayList<ArrayList<Integer>> res = Print(root);
        System.out.println(res);
    }
}

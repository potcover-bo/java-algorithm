package cc.potcover.tree;

import offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * JZ78 把二叉树打印成多行
 */
public class Print2 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                pRoot = queue.poll();
                tempList.add(pRoot.val);
                if (pRoot.left != null) {
                    queue.add(pRoot.left);
                }
                if (pRoot.right != null) {
                    queue.add(pRoot.right);
                }
            }
            res.add(tempList);
        }
        return res;
    }
}
package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    class Node{
        E val;
        Node left, right;

        Node(E e){
            this.val = e;
        }
    }

    private Node root;
    private int size;


    public BST(){
        root = null;
        size = 0;
    }

    /**
     * 当前二分搜索树的节点数
     * @return
     */
    public int size(){
        return this.size;
    }

    /**
     * 是否为空树
     * @return
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * 添加一个元素
     * @param e
     */
    public void add(E e){
        /*if (root == null) {
            root = new Node(e);
            size++;
        }*/
        this.root = add(this.root, e);
    }

    // 递归添加元素
    private void add2(Node node, E e){
        if (e.equals(node.val)) {
            return;
        } else if (e.compareTo(node.val) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        }else if (e.compareTo(node.val) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.val) < 0){
            add(node.left, e);
        }else {
            add(node.right, e);
        }
    }

    // 返回插入新节点后二叉树的根节点
    private Node add(Node node, E e){
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.val) < 0){
            node.left = add(node.left, e);
        } else if (e.compareTo(node.val) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 二叉树搜索
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(this.root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.val) == 0){
            return true;
        } else if (e.compareTo(node.val) > 0) {
            return contains(node.left, e);
        }else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历
     * 访问节点 -> 访问左子树 -> 访问右子树
     */
    public void preOrderRecur(){
        preOrderRecur(this.root);
    }

    private void preOrderRecur(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }

    /**
     * 中序遍历
     * 访问左子树 -> 访问节点 -> 访问右子树
     */
    public void inOrderRecur(){
        inOrderRecur(this.root);
    }

    private void inOrderRecur(Node node) {
        if (node == null) {
            return;
        }
        inOrderRecur(node.left);
        System.out.println(node.val);
        inOrderRecur(node.right);
    }


    /**
     * 后序遍历
     * 访问左子树 -> 访问右子树 -> 访问节点
     */
    public void postOrderRecur(){
        postOrderRecur(this.root);
    }

    private void postOrderRecur(Node node) {
        if (node == null) {
            return;
        }
        postOrderRecur(node.left);
        postOrderRecur(node.right);
        System.out.println(node.val);
    }

    /**
     * 非递归前序遍历
     */
    public void preOrder(){
        if (this.root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(this.root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 非递归中序遍历
     */
    public void inOrder(){
        if (this.root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = this.root;
        while (!stack.isEmpty() || cur != null){
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }

    /**
     * 层序遍历
     */
    public void levelOrder(){
        if (this.root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }

            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 二叉树中的最小值
     * @return
     */
    public E minimum(){
        if (this.size == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }
        return minimum(this.root).val;

    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 二叉树中的最大值
     * @return
     */
    public E maximum(){
        if (this.size == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }
        return maximum(this.root).val;

    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return minimum(node.right);
    }

    /**
     * 删除二分搜索树最小值
     * @return
     */
    public E removeMin(){
        E res = minimum();
        this.root = removeMin(this.root);
        return res;
    }

    // 删除掉以node为根的二分搜索树的最小节点
    // 返回删除后的二分搜索树的根节点
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            // 新的二分搜索树的根
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除二分搜索树中的最大值
     * @return
     */
    public E removeMax(){
        E res = maximum();
        this.root = removeMax(this.root);
        return res;
    }

    // 删除掉以node为根的二分搜索树的最大节点
    // 返回删除后的二分搜索树的根节点
    private Node removeMax(Node node) {

        if (node.right == null) {
            // 递归到底 删除掉当前节点
            Node leftNode = node.left;
            node.left = null;
            // 新的二分搜索树的根
            size--;
            return leftNode;
        }
        node.right = removeMin(node.right);
        return node;
    }

    /**
     * 删除任意元素
     * @param e
     */
    public void remove(E e) {
        this.root = remove(this.root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.val) < 0) {
            node.left = remove(node.left, e);
        } else if (e.compareTo(node.val) > 0) {
            node.right = remove(node.right, e);
        }else {  // e == node.val
            if (node.left == null) { // 左子树为空
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) { // 右子树为空
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }else {
                // 后继节点
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;


                node.left = node.right = null;

                return successor;
            }
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(this.root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.val + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);

    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");

        }
        return res.toString();
    }
}

package tree;

public class SegmentTree<E> {

    private E[] tree;
    private E[] data;

    // 对于两个元素怎么融合
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger){
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * arr.length];

        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 以treeIndex为根节点在l...r区间创建线段树
     * @param treeIndex 根节点索引
     * @param l 区间左边界
     * @param r 区间右边界
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        // 递归种植条件
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        // 左子树根节点索引
        int leftTreeIndex = leftChild(treeIndex);
        // 右子树根节点索引
        int rightTreeIndex = rightChild(treeIndex);

        //二分
        int mid = l + (r - l) / 2;

        // 递归创建左子树
        buildSegmentTree(leftTreeIndex, l, mid);
        // 递归创建右子树
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        // 业务决定 综合两个子树来得到根节点的值
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);

    }

    public int getSize(){
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }
    
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            }else {
                res.append("null");
            }
            if (i != tree.length - 1) {
                res.append(", ");
            }
        }

        res.append("]");

        return res.toString();
    }

    // 返回[queryL, queryR]的值
    public E query(int queryL, int queryR){
        if (queryL < 0 || queryL >= data.length
                || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 在以treeIndex为根节点中在[l, r] 区间查询[queryL, queryR]的值
     * @param treeIndex 根节点索引
     * @param l 线段树左边界
     * @param r 线段树右边界
     * @param queryL 查询区间左边界
     * @param queryR 查询区间右边界
     * @return
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;

        // 左子树根节点索引
        int leftTreeIndex = leftChild(treeIndex);
        // 右子树根节点索引
        int rightTreeIndex = rightChild(treeIndex);


        if (queryL >= mid + 1) {
            //查右子树
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            //查左子树
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        E leftRes = query(leftTreeIndex, l, mid, queryL, mid);
        E rightRes = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);

        return merger.merge(leftRes, rightRes);
    }

    /**
     * 线段树元素更新
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (index >= mid + 1) {
            set(rightTreeIndex, mid + 1, r, index, e);
        }else {
            set(leftTreeIndex, l, mid, index, e);
        }

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);

    }
}

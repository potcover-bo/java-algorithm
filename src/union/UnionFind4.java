package union;

/**
 * 基于rank优化
 */
public class UnionFind4 implements UF{

    private int[] parent;
    private int[] rank; // rank[i]表示以i为根的集合中表示的数的高度

    public UnionFind4(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }


    // p == parent[p] 是一个根节点
    private int find(int p) {

        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("Index is illegal");
        }

        while (p != parent[p]) {
            // 路径压缩
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {

        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        // 根据rank决定合并方向
        if (rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if (rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;

        }else {
            // 高度相等的时候 需要加1
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }

    }
}

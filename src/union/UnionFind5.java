package union;

/**
 * 基于rank优化
 */
public class UnionFind5 implements UF{

    private int[] parent;
    private int[] rank; // rank[i]表示以i为根的集合中表示的数的高度

    public UnionFind5(int size){
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

        if (p != parent[p]) {
            // 递归版本路径压缩 所有节点指向根节点
            parent[p] = find(parent[p]);
        }

        return parent[p];
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

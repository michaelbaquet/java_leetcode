package old;

public class UnionFind2 {

    public int[] root;
    public int[] rank;

    public UnionFind2(int size) {
        root = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public void print(){
        System.out.println("ROOT:");
        for (int i : root) {
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.println("RANK:");
        for (int i : rank) {
            System.out.print(" " + i);

        }
        System.out.println();
    }

}

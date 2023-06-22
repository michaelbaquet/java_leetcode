package old;

public class NumIslands {

    public static void main(String[] args) {

        char[][] grid = new char[][] {{'1','1','1','1','1','0','1','1','1','1'}
                ,{'1','0','1','0','1','1','1','1','1','1'}
                ,{'0','1','1','1','0','1','1','1','1','1'}
                ,{'1','1','0','1','1','0','0','0','0','1'}
                ,{'1','0','1','0','1','0','0','1','0','1'}
                ,{'1','0','0','1','1','1','0','1','0','0'}
                ,{'0','0','1','0','0','1','1','1','1','0'}
                ,{'1','0','1','1','1','0','0','1','1','1'}
                ,{'1','1','1','1','1','1','1','1','0','1'}
                ,{'1','0','1','1','1','1','1','1','1','0'}};


        UnionFindIslands uf = new UnionFindIslands(grid.length * grid[0].length);

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {

                int curr = getId(i, j, grid[i].length);

                if(grid[i][j] == '1') {

                    if(!(i + 1 >= grid.length)) {
                        if(grid[i + 1][j] == '1') {
                            uf.union(curr, getId(i + 1, j, grid[i].length));
                        }
                    }
                    if(!(j + 1 >= grid[i].length)) {
                        if(grid[i][j+1] == '1') {
                            uf.union(curr, getId(i, j+1, grid[i].length));
                        }
                    }

                } else {
                    uf.delete(curr);
                }

            }
        }
        System.out.println(uf.getComponents());

    }

    public int numIslands(char[][] grid) {

        UnionFindIslands uf = new UnionFindIslands(grid.length * grid[0].length);

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {

                int curr = getId(i, j, grid[i].length);

                if(grid[i][j] == '1') {

                    if(!(i + 1 >= grid.length)) {
                        if(grid[i + 1][j] == '1') {
                            uf.union(curr, getId(i + 1, j, grid[i].length));
                        }
                    }
                    if(!(j + 1 >= grid[i].length)) {
                        if(grid[i][j+1] == '1') {
                            uf.union(curr, getId(i, j+1, grid[i].length));
                        }
                    }

                } else {
                    uf.delete(curr);
                }

            }
        }
        return uf.getComponents();
    }


    private static int getId(int i, int j, int colLength) {
        return (i*colLength) + j;
    }




}

 class UnionFindIslands {

    int[] roots;
    int[] size;
    int components;

    public UnionFindIslands(int size) {
        this.roots = new int[size];
        this.size = new int[size];
        components = size;

        for(int i = 0; i < size; i++) {
            this.roots[i] = i;
            this.size[i] = 1;
        }
    }

    public void union(int x, int y) {

        if(find(x) == find(y)){
            return;
        }

        if(size[find(x)] > size[find(y)]) {
            size[find(x)] += size[find(y)];
            roots[find(y)] = roots[x];
        } else {
            size[find(y)] += size[find(x)];
            roots[find(x)] = roots[y];
        }
        components--;
    }

    private int find(int node) {

        int root = node;

        while(root != roots[node]){
            root = roots[node];
        }

        // implement path compression

        while(node != roots[node]) {
            int temp = roots[node];
            roots[node] = root;
            node = temp;
        }

        return root;
    }

    public int getComponents() {
        return components;
    }

    public void delete(int node) {
        roots[node] = -1;
        components--;
    }

}

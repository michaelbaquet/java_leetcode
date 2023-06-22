package old;

public class Running {


    // 0 1 2 3 4 5 6 7 8 9

    public static void main(String[] args) {
        UnionFind uf2 = new UnionFind(10);

        uf2.print();

        uf2.unify(1,9);
        uf2.print();

        uf2.unify(7, 8);
        uf2.print();

        uf2.unify(4,5);
        uf2.print();

        uf2.unify(7,5);
        uf2.print();

        uf2.unify(9, 6);
        uf2.print();

        uf2.unify(6, 4);
        uf2.print();

    }

}

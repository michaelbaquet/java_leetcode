package old;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        generate(99);
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        result.get(0).add(1);
        System.out.println(result.get(0).get(0));

        return null;
    }
}

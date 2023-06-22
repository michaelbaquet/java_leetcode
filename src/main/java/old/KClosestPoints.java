package old;

import java.util.*;

public class KClosestPoints {

    public static void main(String[] args) {
        int[][] tester = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        int[][] result = kClosest(tester, k);


        System.out.println("RESULT |||||||||||||||");
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }

        List<Integer> nList = Arrays.asList(1,2,3);
    }

    public static int[][] kClosest(int[][] points, int k) {

        Comparator<int[]> compa = (a, b) -> (int) ((Math.pow((b[0]), 2) + Math.pow((b[1]), 2)) - (Math.pow((a[0]), 2) + Math.pow((a[1]), 2)));

        PriorityQueue<int[]> pq = new PriorityQueue<>(compa);

        for (int[] point : points) {

            pq.add(point);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[pq.size()][2];
        int amt = pq.size();
        for(int i = 0; i <= amt; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

}

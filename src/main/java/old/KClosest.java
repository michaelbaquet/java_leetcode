package old;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KClosest {

    public static void main(String[] args) {
//        int[][] points = {{-41,72},{53,83},{-95,-31},{-61,68},{32,-56},{16,88},{-81,-48},{-31,56},{-57,-74},{24,-42},{-59,72},{-86,40},{34,-85},{-45,22},{-35,-95}};

//        int top = 9;

        int[][] points = {{3,3},{5,-1},{-2,4}};
        int top = 2;

        int[][] ints = kClosest(points, top);
        for(int[] outer: ints){
            System.out.println(outer[0] + " " + outer[1]);
        }

        int[] a = {1,2,3,4,5};

        List<Integer> b = Arrays.stream(a).boxed().toList();
    }
    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (pair, otherPair) -> (int) ((Math.pow(otherPair[0], 2) + Math.pow(otherPair[1], 2)) - (Math.pow(pair[0],2) + Math.pow(pair[1], 2)))
        );

        for(int[] arr: points) {
            pq.offer(arr);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[pq.size()][2];

        int pqSize = pq.size();
        for(int i = 0 ; i < pqSize; i++) {
            int[] curr = pq.poll();
            res[i] = curr;
        }
        return res;
    }

}

package old;

import java.util.*;
import java.util.PriorityQueue;
import java.util.Queue;


public class TopKFrequent {

    public static void main(String[] args) {
        int[] input = {1,1};

        System.out.println(Arrays.toString(topKFrequent3(input, 1)));


    }


    public static int[] topKFrequent3(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }

        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length];

        for(Integer num: map.keySet()) {
            List<Integer> bucketList = buckets[map.get(num) - 1];
            if(bucketList == null) {
                bucketList = new ArrayList<>();
                buckets[map.get(num) - 1] = bucketList;
            }
            bucketList.add(num);
        }
        int[] result = new int[k];

        int i = 0;
        int j = buckets.length - 1;
        while(i < k) {

            List<Integer> intList = buckets[j];
            if(intList == null) {
                j--;
            } else {
                for(int bInd = 0; bInd < intList.size() && i < k; bInd++) {
                    result[i] = intList.get(bInd);
                    i++;
                }
                j--;
            }
        }
        return result;
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Integer[] keySet = map.keySet().toArray(new Integer[0]);

        int n = keySet.length;
        int kVal = n - k;
        int i = 0;
        int j = 0;
        int pivot = n - 1;
        int pivotPlaced = -1;

        while(pivotPlaced != kVal) {

            while(j < pivot) {
                if(map.get(keySet[j]) < map.get(keySet[pivot])) {
                    swap(i,j,keySet);
                    i++;
                }
                j++;
            }
            swap(i, pivot, keySet);
            pivotPlaced = i;

            if(pivotPlaced > kVal) {
                pivot = pivotPlaced - 1;
                i = 0;
                j = 0;
            } else {
                i = pivotPlaced + 1;
                j = pivotPlaced + 1;
            }
        }

        return Arrays.stream(Arrays.copyOfRange(keySet, kVal, n)).mapToInt(Integer::intValue).toArray();
    }

    public static void swap(int i, int j, Integer[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] topKFrequent(int[] nums, int k) {

        if(nums == null || nums.length == 0) {
            return new int[0];
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Integer> pq = new PriorityQueue<>(
                (n1, n2) -> map.get(n1) - map.get(n2)
        );

        for(int num: map.keySet()) {
            pq.offer(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

}

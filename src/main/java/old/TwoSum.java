package old;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1, 2, 3,4,6}, 10);

        for (int i = 0; i< ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        int[] result = {};

        for(int i = 0; i < nums.length; i++){

            Integer resultIndex = numToIndex.get(target - nums[i]);
            if(resultIndex != null) {
                result = new int[] {resultIndex, i};
            } else {
                numToIndex.put(nums[i], i);
            }
        }
        return result;
    }
}



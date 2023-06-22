package old;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        //[-1,0,1,2,-1,-4]
        //[-1,-1,2,2]

        List<List<Integer>> res = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(res);
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // int k = 0;

        Set<String> checkSet = new HashSet<>();

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {

                if(nums[i] == 0 && nums[j] == 0 && freqMap.get(0) > 2) {
                    String checkString = Arrays.toString(new int[]{0,0,0});
                    if(!checkSet.contains(checkString)) {
                        checkSet.add(checkString);
                        result.add(new ArrayList(List.of(0, 0, 0)));
                    }
                } else {
                    int diff = (nums[i] + nums[j]) * -1;
                    if(freqMap.containsKey(diff)) {
                        if(((nums[i] != diff && nums[j] != diff)) || (nums[i] == diff || nums[j] == diff) && freqMap.get(diff) >= 2) {
                            int[] ints = {diff, nums[i], nums[j]};
                            Arrays.sort(ints);
                            String checkString = Arrays.toString(ints);
                            if(!checkSet.contains(checkString)){
                                checkSet.add(checkString);
                                result.add(new ArrayList(List.of(diff, nums[i], nums[j])));
                            }
                        }
                    }
                }
            }

        }
        return result;
    }


//        Map<Integer, List<Integer>> valToIdx = new HashMap<>();
//
//        public List<List<Integer>> threeSum(int[] nums) {
//
//            List<List<Integer>> result = new ArrayList<>();
//
//            if(nums == null  || nums.length < 3) {
//                return result;
//            }
//
//            //populate map
//            for(int i = 0; i < nums.length; i++) {
//                if(!valToIdx.containsKey(nums[i])) {
//                    valToIdx.put(nums[i], new ArrayList<>());
//                }
//                List<Integer> pp = valToIdx.get(nums[i]);
//                pp.add(i);
//                valToIdx.put(nums[i], pp);
//            }
//
//            Set<Integer> set = new HashSet<>();
//
//            //n^2 time getting pairs
//            for(int i = 0; i < nums.length; i++) {
//                if(!set.contains(nums[i])) {
//                    set.add(nums[i]);
//                    List<List<Integer>> curr = twoSum(nums, i, i+1);
//                    for(List<Integer> list: curr) {
//                        result.add(list);
//                    }
//                }
//            }
//            return result;
//        }
//
//        List<List<Integer>> twoSum(int[] nums, int nIndex, int start) {
//            List<List<Integer>> result = new ArrayList<>();
//
//            for(int i = start; i < nums.length - 1; i++) {
//                int tgt = -1 * (nums[nIndex] + nums[i]);
//
//                if(valToIdx.containsKey(tgt)) {
//                    List<Integer> temp = valToIdx.get(tgt);
//
//                    for(Integer j: temp) {
//                        if(j != nIndex && j != i) {
//                            result.add(new ArrayList<Integer>(Arrays.asList(nums[nIndex], nums[i], nums[j])));
//                        }
//                    }
//                }
//            }
//            return result;
//        }





}

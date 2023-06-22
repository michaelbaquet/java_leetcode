package current;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {

    public static boolean containsDuplicate217(int[] nums) {

        if(nums == null) {
            return false;
        }

        Set<Integer> numSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(numSet.contains(nums[i])) {
                return true;
            }

            numSet.add(nums[i]);

        }

        return false;
    }
}

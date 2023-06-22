package old;

public class MaxContiguousSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int currGroup = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > currGroup + nums[i]) {
                currGroup = nums[i];
            } else {
                currGroup += nums[i];
            }

            if(currGroup > maxSum) {
                maxSum = currGroup;
            }
        }

        return maxSum;

    }
}

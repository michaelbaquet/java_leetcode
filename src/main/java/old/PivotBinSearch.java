package old;

public class PivotBinSearch {

    public static void main(String[] args) {
//        int[] nums = {0,1,2,3,4,5,6};
        int[] nums = {4,5,1,2,3};

        System.out.println(getPivotIndex(nums, 0, nums.length - 1));
    }

    public static int getPivotIndex(int[] nums, int left, int right) {
        //binary search for pivot index
        if (nums[left] < nums[right]) {
            return left;
        }

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid + 1] < nums[mid]) {
                return mid + 1;
            }

            if(nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}

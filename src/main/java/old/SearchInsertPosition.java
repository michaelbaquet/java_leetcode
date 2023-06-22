package old;

public class SearchInsertPosition {

    public static void main(String[] args) {

        int[] nums = {3,5,7,9,10};
        System.out.println(searchInsert(nums, 12));

    }
    public static int searchInsert(int[] nums, int target) {

//        if(nums[0] > target){
//            return 0;
//        } else if(nums[nums.length - 1] < target) {
//            return nums.length;
//        }

        int index = searchInsert(nums, target, 0, nums.length-1);

        if(nums[index] == target){
            return index;
        } else if(nums[index] > target) {
            return index;
        } else {
            return index + 1;
        }
    }

    public static int searchInsert(int[] nums, int target, int beginIndex, int endIndex){
        if(beginIndex>=endIndex){
            return beginIndex;
        }

        int length = endIndex - beginIndex;
        int middle = length/2 + beginIndex;

        if(nums[middle] == target){
            return middle;
        } else if(nums[middle] > target){
            return searchInsert(nums, target, beginIndex, middle - 1);
        } else {
            return searchInsert(nums, target, middle + 1, endIndex);
        }
    }
}

package old;

public class PivotIndex {

    public static void main(String[] args) {
        int[] nums = {-1,-1,0,0,-1,-1};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {

        int[] numsA = new int[nums.length];
        int[] numsB = new int[nums.length];
        int sumA = 0;
        int sumB = 0;
        for(int i = 0; i < nums.length; i++) {
            sumA += nums[i];
            sumB += nums[nums.length - 1 - i];

            numsA[i] = sumA;
            numsB[nums.length - 1 - i] = sumB;
        }

        if(numsB[1] == 0){
            return 0;
        }

        int pivot = -1;

        for(int i = 0; i < nums.length - 2; i++){
            if(numsA[i] == numsB[i + 2]){
                pivot = i + 1;
            }
        }

        if(pivot != -1) {
            return pivot;
        }


        if(numsA[nums.length - 2] == 0){
            return nums.length - 1;
        }

        return pivot;
    }
}

package old;

import java.util.Objects;

public class Twodbinarysearch {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Twodbinarysearch that = (Twodbinarysearch) o;
        return a == that.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    int a = 0;

    public static void main(String[] args) {
//        int[][] arr = new int[][] {{1,3,5,7}, {10,11,16,20},{23,30,34,60}};
//        int[][]  arr = new int[][]{{1}};
//        System.out.println(searchMatrixReal(arr, 3));
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 25; j++) {
                System.out.println(i + String.valueOf(j));
            }
        }




    }

    public static boolean searchMatrixReal(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m*n;

        while(left <= right) {
            int mid = ((right - left) / 2) + left;
            int midVal = matrix[mid/m][mid%n];

            if(midVal == target) {
                return true;
            }

            if(midVal < target) {
                left = mid + 1;
            } else if(midVal > target) {
                right = mid - 1;
            }

        }
        return false;

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] nums = new int[m*n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                nums[i*n + j] = matrix[i][j];
            }
        }

        return binSearch(nums, target);

    }

    public static boolean binSearch(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while(i <= j) {
            int mid = ((j - i) / 2) + i;

            if(nums[mid] == target) {
                return true;
            }

            if(nums[mid] < target) {
                i = mid + 1;
            } else if(nums[mid] > target) {
                j = mid - 1;
            }

        }
        return false;
    }

}

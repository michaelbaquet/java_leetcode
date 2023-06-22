package old;

public class FindDiagonalOrder {


    public static void main(String[] args) {
        int[] arr1 = {11,22,55,66};
        int[] arr2 = {33,44,77,88};
        int[][] combArr = {arr1, arr2};

        int[] arr3 = {11,22};
        int[] arr4 = {33,55};
        int[] arr5 = {44,66};
        int[] arr6 = {77,88};
        int[][] combArr2 = {arr3,arr4, arr5, arr6};

        int[] result = findDiagonalOrder(combArr2);

        for(int i : result) {
            System.out.print(" " + i);
        }

    }

    public static int[] findDiagonalOrder(int[][] mat) {

        //need n*m  length results array
        int[] result = new int[mat.length * mat[0].length];
        int n = mat.length - 1;
        int m = mat[0].length - 1;

        //(n - 1) + (m - 1) in case of 4x4 matrix = 3+3= 6
        //6 is the highest number of index sums ending with (3,3)

        //start at 0 loop to 6

        //Loop starts @ i = 0
        //inner loop loops until j = i
        //if i % 2 == 0 start with left
        //else start with right

        //Loop starts @ i = 0
        //i is even so start with left
        // left and right should always equal i
        //either left for evens or right for odd should always start with i unless i is greater
        // than m - 1 or n - 1

        int outerLoops = n + m;
        int indexCounter = 0;
        for (int i = 0; i <= outerLoops; i++) {
            int left;
            int right;

            if (i % 2 == 0) {
                if (i <= n) {
                    left = i;
                    right = 0;
                } else {
                    left = n;
                    right = i - n;
                }

                while ((left + right == i) && right <= m && left >= 0) {
                    result[indexCounter++] = mat[left][right];
                    left--;
                    right++;
                }

            } else { // if i is odd

                if (i <= m) {
                    right = i;
                    left = 0;
                } else {
                    right = m;
                    left = i - m;
                }

                while ((left + right == i) && left <= n && right >= 0) {
                    result[indexCounter++] = mat[left][right];
                    right--;
                    left++;
                }

            }
        }

        return result;

    }

    public static int[] findDiagonalOrderSomeoneElse(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int r = 0, c = 0, m = matrix.length, n = matrix[0].length, arr[] = new int[m * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[r][c];
            if ((r + c) % 2 == 0) { // moving up
                if      (c == n - 1) { r++; }
                else if (r == 0)     { c++; }
                else            { r--; c++; }
            } else {                // moving down
                if      (r == m - 1) { c++; }
                else if (c == 0)     { r++; }
                else            { r++; c--; }
            }
        }
        return arr;
    }

}

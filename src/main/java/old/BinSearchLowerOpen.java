package old;

public class BinSearchLowerOpen {

    public static void main(String[] args) {

        int[] tester = {0, 2, 5 ,7 ,22, 44, 45};
        int target = 3;
        System.out.println(binSearch(tester, target));
    }


    public static int binSearch(int[] ints, int target) {

        int left = 0;
        int right = ints.length - 1;

        while(left != right) {
            int mid = (right - left) / 2 + left;

            if(ints[mid] > target) {
                right = mid - 1;
            }

            if(ints[mid] < target) {
                left = mid + 1;
            }

            if(ints[mid] == target) {
                return mid;
            }
        }
        return left;
    }
}

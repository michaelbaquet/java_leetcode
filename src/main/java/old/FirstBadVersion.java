package old;

public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {

        int left = 1;
        int right = n;

        while(left < right) {
            int middle = ((right - left) / 2) + left;

            if(isBadVersion(middle)){
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static boolean isBadVersion(int num) {
        return num >= 4;
    }

}

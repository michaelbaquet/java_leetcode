package old;

public class getSum {

    public static void main(String[] args) {

        System.out.println(getSum(11, 17));

    }

    public static int getSum(int a, int b) {

        while(b != 0) {
            int temp = (a & b) << 1;
            a = a^ b;
            b = temp;
        }
        return a;
    }
}

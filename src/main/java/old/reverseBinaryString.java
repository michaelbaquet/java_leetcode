package old;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class reverseBinaryString {

    public static void main(String[] args) {
        String bin2 = "1010";
        String bin1 = "1011";

        int[] arr = {};
        Arrays.sort(arr);



        System.out.println(addBinary(bin1,bin2));
//        String line = "12345";
//        int counter = 0;
//        System.out.println(line.substring(line.length() - counter -1,line.length() - counter));
//        counter++;
//        System.out.println(line.substring(line.length() - counter -1,line.length() - counter));
//        counter++;
//        System.out.println(line.substring(line.length() - counter -1,line.length() - counter));
//        counter++;
//        System.out.println(line.substring(line.length() - counter -1,line.length() - counter));
//        counter++;
//        System.out.println(line.substring(line.length() - counter -1,line.length() - counter));
//        System.out.println(counter);

//        StringBuilder s = new StringBuilder();
//        s.append(0);
//        s.append(0);
//        System.out.println(s);
    }

    public static String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder();
        int carry = 0;
        int aCounter = 0;
        int bCounter = 0;

        while (aCounter < a.length() && bCounter < b.length()) {

            Integer aInt = Integer.valueOf(a.substring(a.length() - aCounter - 1, a.length() - aCounter));
            Integer bInt = Integer.valueOf(b.substring(b.length() - bCounter - 1, b.length() - bCounter));

            Integer value = (aInt + bInt + carry) % 2;
            carry = (aInt + bInt + carry) / 2;

            if (result.length() == 0) {
                result.append(value);
            } else {
                result.insert(0, value);
            }
            aCounter++;
            bCounter++;
        }

        if (aCounter != a.length()) {
            while (aCounter < a.length()) {
                Integer aInt = Integer.valueOf(a.substring(a.length() - aCounter - 1, a.length() - aCounter));
                int value = (aInt + carry) % 2;
                carry = (aInt + carry) / 2;
                result.insert(0, value);
                aCounter++;
            }
        } else if (bCounter != b.length()) {
            while (bCounter < b.length()) {
                Integer bInt = Integer.valueOf(b.substring(b.length() - bCounter - 1, b.length() - bCounter));
                int value = (bInt + carry) % 2;
                carry = (bInt + carry) / 2;
                result.insert(0, value);
                bCounter++;
            }
        }

        if (carry != 0) {
            result.insert(0, carry);
        }

        return result.toString();

    }
}

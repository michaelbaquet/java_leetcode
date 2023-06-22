package old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class PlusOne {

    public static void main(String[] args) {
        int[] i = {5,4,3,9,9};
        int[] ints = plusOneAnswerKey(i);

        for(int inte : ints){
            System.out.print(" " + inte);
        }
    }

    public static int[] plusOneAnswerKey(int[] digits) {
        int n = digits.length;

        // move along the input array starting from the end
        for (int idx = n - 1; idx >= 0; --idx) {
            // set all the nines at the end of array to zeros
            if (digits[idx] == 9) {
                digits[idx] = 0;
            }
            // here we have the rightmost not-nine
            else {
                // increase this rightmost not-nine by 1
                digits[idx]++;
                // and the job is done
                return digits;
            }
        }
        // we're here because all the digits are nines
        digits = new int[n + 1];
        digits[0] = 1;


        return digits;
    }

    public static int[] plusOne(int[] digits) {
        LinkedList<Integer> list = new LinkedList<>();

        int addValue = 1;
        int index = digits.length - 1;
        while (addValue >= 1 && index >= 0) {
            int newDigit = digits[index] + addValue;

            list.addFirst(newDigit % 10);

            addValue = newDigit / 10;
            index--;
        }

        if (addValue == 1) {
            list.addFirst(1);
        } else if (list.size() != digits.length) {
            for (int i = digits.length - list.size() - 1; i >= 0; i--) {
                list.addFirst(digits[i]);
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}

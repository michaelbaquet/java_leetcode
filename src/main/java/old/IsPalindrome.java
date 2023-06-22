package old;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

        Integer[] a = new Integer[]{1,2,3,4};

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.addAll(Arrays.asList(a));
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());


    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() -1;
        boolean y = true;
        while(i < j) {

            if(!Character.isLetter(s.charAt(i))){
                i++;
            } else if (!Character.isLetter(s.charAt(j))) {
                j--;
            } else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }

        }
        return true;
    }
}

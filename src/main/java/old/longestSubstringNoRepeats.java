package old;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class longestSubstringNoRepeats {

    public static void main(String[] args) {
        System.out.println(getUniqueCharacter("hhaabccd"));
    }

    public static int getUniqueCharacter(String s) {
        // Write your code here

        Map<Character, Integer> charMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            if(charMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;

    }

    public static long solution(String s) {
        // Type your solution here

        if(s == null) {
            return 0;
        }


        int left = 0;
        int right = 0;
        int maxSize = 0;
        HashSet<Character> window = new HashSet<Character>();

        while(right < s.length()) {
            Character currRight = Character.valueOf(s.charAt(right));
            if(!window.contains(currRight)) {
                window.add(currRight);
                maxSize = Math.max(maxSize, window.size());
                right++;
            } else {
                Character currLeft = Character.valueOf(s.charAt(left));
                window.remove(currLeft);
                left++;
            }
        }

        return maxSize;
    }



}

package old;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class IsAnagram {

    public static void main(String[] args) {
        String s = "car";
        String t = "raz";

        System.out.println(isAnagramWithTreeMap(s, t));
    }

    public static boolean isAnagramWithTreeMap(String s1, String s2) {

        if(s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        TreeMap<Character, Integer> mapS1 = new TreeMap<>();
        TreeMap<Character, Integer> mapS2 = new TreeMap<>();

        for(char c: s1.toCharArray()) {
            if(!mapS1.containsKey(c)) {
                mapS1.put(c, 0);
            }
            mapS1.put(c, mapS1.get(c) + 1);
        }

        for(char c : s2.toCharArray()) {
            if(!mapS2.containsKey(c)) {
                mapS2.put(c, 0);
            }
            mapS2.put(c, mapS2.get(c) + 1);
        }

        return mapS1.equals(mapS2);

    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char curr1 = s.charAt(i);
            char curr2 = t.charAt(i);

            if (!map.containsKey(curr1)) {
                map.put(curr1, 1);
            } else {
                map.put(curr1, map.get(curr1) + 1);
            }

            if (!map2.containsKey(curr2)) {
                map2.put(curr2, 1);
            } else {
                map2.put(curr2, map2.get(curr2) + 1);
            }
        }

        for (Character c : map.keySet()) {
            if (!Objects.equals(map.get(c), map2.get(c))) {
                return false;
            }
        }
        return true;
    }

}

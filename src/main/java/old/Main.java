package old;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(getResult("acb", "cba", "cdb"));
    }

    public static boolean getResult(String a, String b, String c) {
        return getNumberValue(a) + getNumberValue(b) == getNumberValue(c);
    }

    public static int getNumberValue(String str) {

        String collected = str.chars().mapToObj(value -> value - 'a')
                .map(String::valueOf).collect(Collectors.joining());

        System.out.println(collected);

        return Integer.valueOf(collected);
    }
}

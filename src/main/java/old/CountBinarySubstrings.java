package old;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CountBinarySubstrings {

    public static void main(String[] args) {
        String s = "00110011";

        System.out.println(countBinarySubstrings(s));
    }

    public static int countBinarySubstrings(String s) {

        int result = 0;
        Stack<Character> stack;

        for(int i = 0; i < s.length(); i++){
            stack = new Stack<>();
            stack.push(s.charAt(i));

            for(int j = i + 1; j < s.length(); j++){
                if(stack.peek() != s.charAt(j)){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    result++;
                    break;
                }
                stack.push(s.charAt(j));
            }
        }
        return result;
    }
}

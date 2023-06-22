package old;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        String s = "(){}}{";

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        if (s.length() % 2 != 0 || s.length() < 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {

            if (!stack.empty()) {
                switch (stack.peek()) {
                    case '(':
                        if (s.charAt(i) == ')') {
                            stack.pop();
                            break;
                        }
                        stack.push(s.charAt(i));
                        break;
                    case '{':
                        if (s.charAt(i) == '}') {
                            stack.pop();
                            break;
                        }
                        stack.push(s.charAt(i));
                        break;
                    case '[':
                        if (s.charAt(i) == ']') {
                            stack.pop();
                            break;
                        }
                        stack.push(s.charAt(i));
                        break;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }

}

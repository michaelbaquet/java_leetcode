package old;

public class ValidPalidrome {


    public boolean isPalindrome(String input) {



        if(input == null) {
            return false;
        }

        int start = 0;
        int end = input.length() - 1;

        while(start < end) {
            char c1 = input.charAt(start);
            char c2 = input.charAt(end);

            if(!Character.isLetterOrDigit(c1)) {
                start++;
            } else if(!Character.isLetterOrDigit(c2)) {
                end--;
            } else if(Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                return false;
            } else {
                start++;
                end--;
            }
        }

        return true;
    }


    public String test(String test) {
        return test + "1";
    }

}

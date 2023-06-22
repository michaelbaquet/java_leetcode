package old;

public class ValidPalindrome1Sub {


    //Follow up solve this for N substitutions

    public static void main(String[] args) {
        String s = "aabaacc";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {

        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                if(!isPalindrome(s, i + 1, j) && !isPalindrome(s, i, j - 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s, int i, int j) {

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

}

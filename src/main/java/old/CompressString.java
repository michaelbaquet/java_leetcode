package old;

public class CompressString {

    public static void main(String[] args) {

        String input = "Aaabccc";
        String input1 = "Abccde";


        System.out.println(compressString(input));
        System.out.println(compressString(input1));
    }


    public static String compressString(String input){
        if(input.length() <= 2) {
            return input;
        }
        int pointerA = 0;
        int pointerB = 0;
        StringBuilder result = new StringBuilder();

        while(pointerA < input.length()){
            while(pointerB < input.length() && input.charAt(pointerB) == input.charAt(pointerA)) {
                pointerB++;
            }

            result.append(input.charAt(pointerA));

            if(pointerB - pointerA > 1) {
                result.append(pointerB - pointerA);
            }
            pointerA = pointerB;
        }
        return result.length() < input.length() ? result.toString() : input;
    }
}

package old;

public class MinimumFipsBinaryString {

    public static void main(String[] args) {

        String s = "01001001101";

        System.out.println(minFlips(s));
        System.out.println(minFlipsWrong(s));
        System.out.println(minFlipsBruteForce(s));
    }


    public static int minFlips(String s){

        int n=s.length();

        int minOperations=n, minCount1=0, minCount2=0;
        //minCount1 for this pattern 0101010...
        //minCount2 for this pattern 1010101...
        for(int i=0;i<2*n;i++){

            int rem = i%n;
            //Check for case1 where 010101....
            if(i%2 == 0 && s.charAt(rem) == '0') minCount1++;
            if(i%2 != 0 && s.charAt(rem) =='1') minCount1++;

            //check for case2 where 101010...
            if(i%2 == 0 && s.charAt(rem) == '1') minCount2++;
            if(i%2 != 0 && s.charAt(rem) =='0') minCount2++;


            //tricky One : remove count which are not relvent for current window
            if(i>=n){
                //Check for case1 where 010101....
                if(rem%2 == 0 && s.charAt(rem) == '0') minCount1--;
                if(rem%2 != 0 && s.charAt(rem) =='1') minCount1--;

                //check for case2 where 101010...
                if(rem%2 == 0 && s.charAt(rem) == '1') minCount2--;
                if(rem%2 != 0 && s.charAt(rem) =='0') minCount2--;

                minOperations=Math.min(minOperations,Math.min(minCount1,minCount2));
            }
        }
        return minOperations;
    }

    public static int minFlipsWrong(String s){
        int min = Integer.MAX_VALUE;
        int length = s.length() * 2;
        int min010 = 0;
        int min101 = 0;
        for(int i = 0; i < length ; i++){
            int rem = i % s.length();

            //check for 010101010
            if(i%2==0 && s.charAt(rem) == '1') min010++;
            if(i%2!=0 && s.charAt(rem) == '0') min010++;

            //check for 10101010
            if(i%2==0 && s.charAt(rem)=='0') min101++;
            if(i%2!=0 && s.charAt(rem)=='1') min101++;

            if(i >= s.length()) {
                //check for 010101010
                if(rem%2==0 && s.charAt(rem) == '1') min010--;
                if(rem%2!=0 && s.charAt(rem) == '0') min010--;

                //check for 10101010
                if(rem%2==0 && s.charAt(rem)=='0') min101--;
                if(rem%2!=0 && s.charAt(rem)=='1') min101--;

                min = Math.min(min, Math.min(min010,min101));
            }
        }
        return min;
    }

    public static int minFlipsBruteForce(String s) {

        String doubleS = s.concat(s);
        String s1 = "";
        String s2 ="";

        for(int i = 0; i < doubleS.length(); i++){
            s1 += i % 2;
            s2 += (i+1) % 2;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++){
            int s1Diff = 0;
            int s2Diff = 0;
            for(int j = i; j < s.length() + i; j++) {
                s1Diff += Math.abs(doubleS.charAt(j) - s1.charAt(j));
                s2Diff += Math.abs(doubleS.charAt(j) - s2.charAt(j));
            }
            min = Math.min(Math.min(s1Diff, s2Diff), min);
        }
        return min;
    }
}

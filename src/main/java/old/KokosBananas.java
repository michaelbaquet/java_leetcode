package old;

public class KokosBananas {

    public static void main(String[] args) {
//        int[] piles = {10};
//        int hrs = 2;
//        System.out.println(minEatingSpeed(piles, hrs));
        System.out.println(Math.ceil((double)9/2));
    }

    public static int minEatingSpeed(int[] piles, int h) {

        int bph = 0;
        boolean found = false;

        while(!found) {

            bph += 1;
            found = helper(piles, h, bph);
        }

        return bph;
    }

    public static boolean helper(int[] piles, int h, int bph) {

        int ind = 0;
        int hours = 0;

        while(hours < h && ind < piles.length) {

            int currVal = piles[ind];
            currVal -= bph;

            if(currVal <= 0) {
                ind++;
            } else {
                piles[ind] = currVal;
            }

            hours++;
        }
        return ind == piles.length && hours <= h;
    }
}

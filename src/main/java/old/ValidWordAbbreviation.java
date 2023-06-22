package old;

public class ValidWordAbbreviation {

    public static void main(String[] args) {

        System.out.println(validWordAbbreviation("substitution", "s10n"));

    }


    public static boolean validWordAbbreviation(String word, String abbr) {

        int wordIndex = 0;

        for(int i = 0; i < abbr.length(); i++) {

            if(Character.isDigit(abbr.charAt(i))) {
                int totDig = 1;
                for(int j = i + 1; j < abbr.length(); j++) {
                    if(Character.isDigit(abbr.charAt(j))) {
                        totDig++;
                    } else {
                        break;
                    }
                }
                Integer currAbb = Integer.valueOf(abbr.substring(i, totDig + i));

                wordIndex += currAbb;

                if(wordIndex > word.length()) {
                    return false;
                }

                i += totDig - 1;

            } else {
                if(abbr.charAt(i) != word.charAt(wordIndex)) {
                    return false;
                }
                wordIndex++;
            }
        }

        return wordIndex == word.length();
    }

}

package old;

public class ReorderDataLogFiles {

    public static void main(String[] args) {
        String[] strings = reorderLogFiles(new String[]{"u 4374249", "q 2066 2 6", "fz tgthz w", "j 31227 50", "lm 91 25 6", "ow uhjqes", "v jmkmsi b", "0 amxan w", "0y q wssft", "d ekx ls d"});

        for(String s: strings){
            System.out.println(s);
        }
    }

    public static String[] reorderLogFiles(String[] logs) {

        String[] digArray = new String[logs.length];
        int digCount = 0;
        String[] wordArray = new String[logs.length];
        int wordCount = 0;

        for(String s: logs) {
            int index = s.indexOf(" ");
            if(Character.isDigit(s.charAt(index + 1))) {
                digArray[digCount] = s;
                digCount++;
            } else {
                wordArray[wordCount] = s;
                wordCount++;
            }
        }

        //Sort word array

        for(int i = 0; i < wordCount - 1; i++) {

            for(int j = i + 1; j < wordCount; j++) {
                int indexI = wordArray[i].indexOf(" ");
                int indexJ = wordArray[j].indexOf(" ");
                if(indexI + 1 < wordArray[i].length() && indexJ + 1 < wordArray[j].length()){
                    int compare = wordArray[i].substring(indexI + 1).compareTo(wordArray[j].substring(indexJ + 1));
                    if(compare >= 1) {
                        String temp = wordArray[i];
                        wordArray[i] = wordArray[j];
                        wordArray[j] = temp;
                    } else if(compare == 0) {
                        int comparePre = wordArray[i].substring(0, indexI)
                                .compareTo(wordArray[j].substring(0, indexJ));
                        if(comparePre >= 1) {
                            String temp = wordArray[i];
                            wordArray[i] = wordArray[j];
                            wordArray[j] = temp;
                        }
                    }
                }
            }

        }

        //merge digArray;

        for(int i = 0; i < digCount; i++) {
            wordArray[wordCount] = digArray[i];
            wordCount++;
        }

        return wordArray;
    }

}

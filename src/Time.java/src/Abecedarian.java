public class Abecedarian {
    /**
     * A word is said to be “abecedarian” if the letters in the word
     * appear in alphabetical order. For example, the following are all six-letter
     * English abecedarian words:
     * abdest, acknow, acorsy, adempt, adipsy, agnosy, befist, behint, beknow, bijoux, biopsy, cestuy, chintz, deflux, dehors, dehort, deinos,
     * diluvy, dimpsy
     * Write a method called isAbecedarian that takes a String and returns a
     * boolean indicating whether the word is abecedarian
     * @param args
     */
    public static void main(String[] args){
        String word = "abcdefghka";
       System.out.println(isAbecedarian(word));
    }

    public static boolean isAbecedarian(String anyWord) {
        char letter = 'a';
        boolean flag = true;
        for (int i = 0; i < anyWord.length(); i++ ) {

            if (anyWord.charAt(i) >= letter) {
                flag = true;
                letter = anyWord.charAt(i);
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}

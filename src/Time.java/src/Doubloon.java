public class Doubloon {

    public static void main(String[] args){
        String anyString = "Shanghaiings".toLowerCase();
        System.out.printf("That the string '%s' is a doubloon is: %b ", anyString, isDoubloonOOfN2(anyString));
    }
    //O(n*n)
    public static boolean isDoubloonOOfNSquare(String anyWord){
        boolean flag = true;
        //get the character of each index starting from 0 then count the number
        // of times it appears in the entire string
        for(int i=0; i< anyWord.length(); i++){
            char letter = anyWord.charAt(i);
            int count = 0;
            for (int j=0; j<anyWord.length();j++){
                if (letter == anyWord.charAt(j)){
                    count++;
                }
            }
            if (count == 2) { }
            else{
                flag = false;
                break;
            }
        }
        return flag;
    }
    //O(n)
    public static boolean isDoubloonOOfN(String anyWord){
        int[] characterCount = new int[26];
        for(int i = 0; i < anyWord.length(); i++){
           int characterASCIIValue = (int) anyWord.charAt(i);
           int characterCountIndex = characterASCIIValue - 97;
           characterCount[characterCountIndex]+=1;
        }
        for (int i = 0; i < characterCount.length; i++){
            if(characterCount[i] == 0 || characterCount[i] ==2){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    //O(n) more readable
    public static boolean isDoubloonOOfN2(String anyWord){
        int[] counts = new int[26];
        for (char letter : anyWord.toCharArray()){ // convert string to an array of characters and loop through,
            int index = letter - 'a';
            counts[index]++;
        }
        for(int count: counts){
            if(count != 0 && count !=2){
                return false;
            }
        }
        return true;
    }

}

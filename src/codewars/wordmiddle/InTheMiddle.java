package codewars.wordmiddle;

/**
 * Return the middle part of a word.
 *
 *  If even> the 2 chars in the middle, if odd> single character
 */
public class InTheMiddle {

    public static void main(String[] args) {
        System.out.println(getMiddle("word"));
        System.out.println(getMiddle("a"));
        //System.out.println(getMiddle("")); not a valid word
        System.out.println(getMiddle("cinco"));

    }

    public static String getMiddle(String word) {

        //even
        if(word.length()%2 == 0){
            int index = word.length()/2 -1; //-1 to offset 0 index
            return word.charAt(index)+""+word.charAt(index+1);
        }else{//odd
            int index = word.length()/2;
            return word.charAt(index)+"";   //no +1 to offset 0 index
        }


    }
}

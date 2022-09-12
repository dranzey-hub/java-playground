package CodeSignal.arrays;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepChar {

    public static void main(String[] args) {
        String s = "abacabad";

        System.out.print("First non repeated char in '"+s+"'");
        System.out.print(" is: "+firstNotRepeatingCharacter(s));
    }


    /**
     Given a string s consisting of small English letters, find and return the first instance
     of a non-repeating character in it. If there is no such character, return '_'.

     Example

     For s = "abacabad", the output should be
     firstNotRepeatingCharacter(s) = 'c'.
     */
    static char firstNotRepeatingCharacter(String s)
    {
        //map char and its count,index
        HashMap<Character, Pair> m = new HashMap<>();

        for(int i=0; i<s.length(); i++)
        {
            if(!m.containsKey(s.charAt(i)))
                m.put(s.charAt(i),new Pair(1, i));      //we only care about loners
            else
                m.put(s.charAt(i), new Pair(-1, i));    //quemado
        }

        //now just get the loner char with the lowest index, if none return '_'
        char x = '_';
        Integer lowestIndex = null;
        for(Map.Entry e : m.entrySet())
        {
            if( ((Pair)(e.getValue())).c != -1)
            {
                if(lowestIndex==null)
                    lowestIndex = ((Pair)(e.getValue())).i;  //1st encounter
                else{
                    int tmp = ((Pair)e.getValue()).i;
                    if(tmp < lowestIndex){
                        lowestIndex = tmp;
                    }
                }
            }
        }

        if(lowestIndex!=null)
            return s.charAt(lowestIndex);
        else
            return x;

    }


    /**
     * Pair of count (number of appearances) and index (pos. in array) of a char in a String
     */
    static class Pair{
        int c;  //count
        int i;  //index

        public Pair(){}

        public Pair(int c, int index){
            this.c = c;
            i = index;
        }

    }

}

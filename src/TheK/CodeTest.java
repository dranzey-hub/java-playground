package TheK;

import java.util.HashMap;
import java.util.Map;

public class CodeTest
{
    public static void main(String[] args)
    {

        String s1 = "e lboW  %$@#;";
        String s2 = "below";

        System.out.print(areAnagrams(s1, s2));
    }

    /**
     *
     * @return true if both strings are anagram (same letters (ignore non-letter chars), different order)
     */
    public static boolean areAnagrams(String str1, String str2)
    {
        // [!] use SB since immutability of String will create problems in length once modified
        StringBuilder s1 = new StringBuilder(str1.toLowerCase());
        StringBuilder s2 = new StringBuilder(str2.toLowerCase());

        //clean strings
        removeNonLetters(s1);
        removeNonLetters(s2);

        //first check if they're same length
        if(s1.length() != s2.length())
            return false;

        //map chars
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();

        mapChars(s1.toString(), hm1);
        mapChars(s2.toString(), hm2);

        //compare both hash maps... if missing a char or count doesn't match returns false
        //Iterator i = hm.entrySet().iterator();
        for(Map.Entry e : hm1.entrySet())
        {
            //if one doesn't match return false
            if(hm2.containsKey(e.getKey()))
            {    //not having the same value
                if(hm2.get(e.getKey()) != e.getValue())
                    return false;
            }else   //not having the same char
                return false;
        }

        return true;
    }





    static void removeNonLetters(StringBuilder s)
    {

        //replace by regex
        //return s.replaceAll("[^a-z]","");

        //or use ascii code
        for(int i=0; i<s.length(); i++)
        {
            //[a-z]
            if( !(s.charAt(i) > 96 && s.charAt(i) < 123) )
            {
                s.replace(i, i+1, "");
                i--;
            }
        }
    }

    static void mapChars(String s, HashMap<Character, Integer> hm)
    {
        //iterate over first string and check how many chars of each we have
        for(int i=0; i<s.length(); i++){
            //use hm to know how many chars we have of each...
            char c = s.charAt(i);
            //if char present, update counter
            if(hm.containsKey(c)){
                int count = hm.get(c);
                count ++;
                hm.put(c,count);
            }else{  //else just start the count
                hm.put(c, 1);
            }
        }
    }

}

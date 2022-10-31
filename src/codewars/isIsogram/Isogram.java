package codewars.isIsogram;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * An isogram: word with non repeating characters
 *      assume empty string is isogram, it will contain only letters and ignore case.
 */
public class Isogram {

    public static void main(String[] args) {
        System.out.println(Isogram.isIsogram("Dermatoglyphics"));
        System.out.println(Isogram.isIsogram_streams("Dermatoglyphics"));
    }

    public static boolean isIsogram(String str)
    {
        if(str.isEmpty()) return true;

        char[] chars = str.toCharArray();
        Map<Character,Integer> map = new HashMap();
        for(char c : chars){
            if(map.containsKey(Character.toUpperCase(c)))
                return false;
            else{
                map.put(Character.toUpperCase(c),1);
            }
        }
        return true;
    }

    public static boolean isIsogram_streams(String str)
    {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
}
